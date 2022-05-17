package a;

import java.util.List;

public class DbExam5 {
	public static void main(String args[]) {
		
		Product product = new Product();
		product.setProductName("ボールペン");
		product.setPrice(200);
		new ProductDao(DbUtil.getConnection()).register(product);
		
		List<Product> list = new ProductDao(DbUtil.getConnection()).findAll();
		for(Product pro : list) {
			System.out.println("product_id:"+pro.getProductId()+", product_name:"+pro.getProductName()+", price:"+pro.getPrice());
		}
	}
}
