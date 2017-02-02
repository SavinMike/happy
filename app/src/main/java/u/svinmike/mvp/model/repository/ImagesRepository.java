package u.svinmike.mvp.model.repository;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Single;
import u.svinmike.di.DependencyManager;
import u.svinmike.mvp.model.data.Image;
import u.svinmike.mvp.model.formatter.StringDateFormatter;
import u.svinmike.mvp.model.stoarage.ImageStorage;

/**
 * Date: 02.02.2017
 * Time: 11:05
 *
 * @author Savin Mikhail
 */
public class ImagesRepository {
	private static final String TAG = "ImagesRepository";

	private final ImageStorage imageStorage;
	final StringDateFormatter stringDateFormatter;

	@Inject
	public ImagesRepository(final ImageStorage imageStorage, final StringDateFormatter stringDateFormatter) {
		this.imageStorage = imageStorage;
		this.stringDateFormatter = stringDateFormatter;
	}

	public Single<List<Image>> getAll() {
		return imageStorage.getAll()
				.filter(images -> !images.isEmpty())
				.switchIfEmpty(Maybe.<List<Image>>create(emmiter -> emmiter.onSuccess(generateImages()))
						.doOnSuccess(imageStorage::recreateTable))
				.toSingle();
	}

	private List<Image> generateImages() {
		List<Image> images = new ArrayList<>();
		AssetManager assetManager = DependencyManager.getAppComponent().context().getAssets();

		String[] galleries;
		try {
			galleries = assetManager.list("gallery");
		}
		catch (IOException e) {
			e.printStackTrace();
			return images;
		}

		for (String files : galleries) {
			Pattern compile = Pattern.compile("([\\d\\.]*)_\\$(.*)__(.*)\\$(_thumb){0,1}\\.(\\w*)");
			Matcher matcher = compile.matcher(files);
			if (matcher.find()) {
				images.add(Image.builder()
						.date(stringDateFormatter.format(matcher.group(1)))
						.category(matcher.group(2))
						.title(matcher.group(3))
						.thumb(matcher.group(4) != null)
						.image(matcher.group(0))
						.build());
			} else {
				Log.d(TAG, files);
			}
		}
		Collections.sort(images);
		return images;
	}
}
