package a;

public class DbDevExam5_Select {
	public static void main(String args[]) {
		Product pro = new ProductDao(DbUtil.getConnection()).findByProductId(102);
		System.out.println("product_id:"+pro.getProductId()+", product_name:"+pro.getProductName()+", price:"+pro.getPrice());
	}
}
