package memo.singletonMemo.anotherExample;

public class ShopServiceMain {

	public static void main(String[] args) {
		ShopService service = ShopService.getInstance();
		
		service.initialize("고구마 먹고싶다");
		System.out.println(service.getShopName());
		
		service.initialize("sdfsdf");
		System.out.println(service.getShopName());
	}

}
