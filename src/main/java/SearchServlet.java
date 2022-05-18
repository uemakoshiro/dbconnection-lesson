package src.main.java;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    	String id = request.getParameter("id");
    	
    	if(id.isEmpty() || id.equals(null)) {
    		request.setAttribute("msg", "product_idを入力してください");
    		request.getRequestDispatcher("top.jsp").forward(request, response);
    	}
    	int idInt = Integer.parseInt(id);
    	Product product = new ProductService().searchId(idInt);
    	if(product == null) {
    		request.setAttribute("msg", "対象のデータはありません");
    		request.getRequestDispatcher("top.jsp").forward(request, response);
    	}
    	
    	request.setAttribute("product", product);
    	
    	request.getRequestDispatcher("searchResult.jsp").forward(request, response);
    }
}
