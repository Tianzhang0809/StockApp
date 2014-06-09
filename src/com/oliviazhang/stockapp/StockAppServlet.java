package com.oliviazhang.stockapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StockAppServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String price = "";
		String company = "";
		String peg = "";
		String symbol = req.getParameter("s");

		GetStockModel getStockModel = new GetStockModel();

		if (symbol != null) {

			getStockModel.doStockSearch(symbol);
			company = getStockModel.getCompany();
			price = getStockModel.getPrice();
			peg = getStockModel.getPeg();
		}

		req.setAttribute("company", company);
		req.setAttribute("price", price);
		req.setAttribute("peg", peg);
		RequestDispatcher view = getServletContext().getRequestDispatcher(
				"/result.jsp");
		view.forward(req, resp);
	}
}
