package a;

public class DbDevExam5_Update {
	public static void main(String args[]) {
		Product beforePro = new ProductDao(DbUtil.getConnection()).findByProductId(101);
		System.out.println("【更新前】");
		System.out.println("product_id:"+beforePro.getProductId()+", product_name:"+beforePro.getProductName()+", price:"+beforePro.getPrice());
		
		Product setPro = new Product(101,"シャープペンシル",70);
		new ProductDao(DbUtil.getConnection()).update(setPro);
		Product afterPro = new ProductDao(DbUtil.getConnection()).findByProductId(101);
		System.out.println("【更新後】");
		System.out.println("product_id:"+afterPro.getProductId()+", product_name:"+afterPro.getProductName()+", price:"+afterPro.getPrice());
		
	}
}
