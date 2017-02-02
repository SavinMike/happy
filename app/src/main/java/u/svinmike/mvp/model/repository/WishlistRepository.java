package u.svinmike.mvp.model.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Single;
import u.svinmike.R;
import u.svinmike.mvp.model.data.WishList;
import u.svinmike.mvp.model.stoarage.WishlistStorage;

/**
 * Date: 02.02.2017
 * Time: 11:05
 *
 * @author Savin Mikhail
 */
public class WishlistRepository {

	private final WishlistStorage wishlistStorage;

	@Inject
	public WishlistRepository(final WishlistStorage wishlistStorage) {
		this.wishlistStorage = wishlistStorage;
	}

	public Single<List<WishList>> getAll() {
		return wishlistStorage.getAll()
				.filter(wishLists -> !wishLists.isEmpty())
				.switchIfEmpty(Maybe.<List<WishList>>create(emmiter -> emmiter.onSuccess(generateWishList()))
						.doOnSuccess(wishlistStorage::recreateTable))
				.toSingle();
	}

	private List<WishList> generateWishList() {
		List<WishList> wishLists = new ArrayList<>();
		wishLists.add(WishList.builder()
				.image(R.drawable.ic_wishlist_spa)
				.title("Поход в SPA")
				.description("Разовый поход в любой SPA солон. Необходимо придупридить за 2 недели.")
				.price(5000f)
				.count(1)
				.build());
		return wishLists;
	}
}
