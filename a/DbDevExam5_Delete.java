package a;

import java.util.List;

public class DbDevExam5_Delete {
	public static void main(String args[]) {
		new ProductDao(DbUtil.getConnection()).delete("ボールペン");
		
		List<Product> list = new ProductDao(DbUtil.getConnection()).findAll();
		for(Product pro : list) {
			System.out.println("product_id:"+pro.getProductId()+", product_name:"+pro.getProductName()+", price:"+pro.getPrice());
		}
	}
}
