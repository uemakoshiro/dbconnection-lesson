package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.entity.Product;
import jp.co.axiz.service.ProductService;
/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
    	
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
    	String name = request.getParameter("name");
    	String priceStr = request.getParameter("price");
    	String btn = request.getParameter("btn");
    	Integer price = null;
    	
    	if(btn.equals("search")) {
	    	if(!"".equals(priceStr)) {
	    		price = Integer.parseInt(priceStr);
	    	}
	    	Product pd = new Product();
	    	pd.setProductName(name);
	    	pd.setPrice(price);
	    	
	    	List<Product> list = new ProductService().search(pd);
	    	
	    	if(list.isEmpty()) {
	    		request.setAttribute("msg", "対象のデータはありません");
	    		request.getRequestDispatcher("top.jsp").forward(request, response);
	    	}
	    	
	    	request.setAttribute("list", list);
	    	request.getRequestDispatcher("searchResult.jsp").forward(request, response);
    	}
    	else {
    		if("".equals(name) || "".equals(priceStr)) {
    			int flag = 0;
    			if("".equals(name)) {
    				flag += 10;
    			}if("".equals(priceStr)) {
    				flag += 1;
    			}
    			request.setAttribute("flag", flag);
	    		request.getRequestDispatcher("top.jsp").forward(request, response);
	    	}else {
	    		price = Integer.parseInt(priceStr);
	    		Product pd = new Product();
	    		pd.setProductName(name);
	    		pd.setPrice(price);
	    		new ProductService().register(pd);
	    		request.getRequestDispatcher("insertResult.jsp").forward(request, response);
	    	}
    	}
    }
}
