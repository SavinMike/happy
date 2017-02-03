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
				.id(0)
				.image(R.drawable.ic_wishlist_spa)
				.title("Поход в SPA")
				.description("Разовый поход в любой SPA солон. Необходимо предупредить за 2 недели.")
				.price(5000f)
				.count(1)
				.build());

		wishLists.add(WishList.builder()
				.id(1)
				.image(R.drawable.ic_wishlist_roof)
				.title("Хочу романтики")
				.description("Прекрасный романтический ужин на крыше Новосибирска. Подробнее https://vk.com/nskroof. Необходимо предупредить за 2 недели.")
				.count(1)
				.build());

		wishLists.add(WishList.builder()
				.id(2)
				.image(R.drawable.ic_wishlist_free_days)
				.title("Так не хочеться ни куда вставать.")
				.description("Пинаешь мужа и говоришь, что сегодня не хочешь вести детей в садик, собирать их, одевать и т.д. Муж собирает детей, отводит их в садик и приезжает за тобой любимой).")
				.count(5)
				.build());

		wishLists.add(WishList.builder()
				.id(3)
				.image(R.drawable.ic_wishlist_theater)
				.title("Хочу в театр")
				.description("Муж предлогает тебе на выбор несколько спектаклей, покупает понравившиеся тебе и идет с тобой туда. Необходимо предупредить за 1 месяц.")
				.count(3)
				.build());

		wishLists.add(WishList.builder()
				.id(4)
				.image(R.drawable.ic_wishlist_shopping)
				.title("Мне не чего одеть.")
				.description("Ну что-же теперь не отвертишься. Муж берет тебя и едит с тобой по магазинам в поисках чего-нибудь интересного. Честно пытаеться не зевать и не ищет повода, чтобы сбежать. Необходимо предупредить за 2 недели.")
				.count(1)
				.price(6000f)
				.build());


		wishLists.add(WishList.builder()
				.id(5)
				.image(R.drawable.ic_wishlist_breakfast)
				.title("Где мой завтрак в постель?")
				.description("Инструкция:\n1) Пинаешь мужа и говоришь, что ты хочешь на завтрак.\n2)Муж встает с постели и идет делать тебе самый лучший завтрак.\n3) PROFIT")
				.count(7)
				.build());

		wishLists.add(WishList.builder()
				.id(6)
				.image(R.drawable.ic_wishlist_sexshop)
				.title("Где моя плетка?")
				.description("Ну тут и так все понятно...")
				.price(5000f)
				.count(1)
				.build());

		wishLists.add(WishList.builder()
				.id(7)
				.image(R.drawable.ic_wishlist_run)
				.title("Так хочется убежать куда-нибудь...")
				.description("Собираемся и едим куда-нибудь далеко далеко")
				.count(1)
				.build());

		wishLists.add(WishList.builder()
				.id(8)
				.image(R.drawable.ic_wishlist_massage)
				.title("Где мой массаж?")
				.count(7)
				.build());

		return wishLists;
	}

	public Maybe<WishList> getWishListDetail(final int id) {
		return wishlistStorage.getById(id);
	}
}
