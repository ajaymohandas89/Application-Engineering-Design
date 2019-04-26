package com.myproject.product.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Header;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
import com.myproject.product.dao.CategoryDAO;
import com.myproject.product.exception.ProductException;
import com.myproject.product.pojo.Product;

public class ProductDetailPDFImpl extends AbstractPdfView{
	
	private CategoryDAO categoryDao;
	private String selectedCategory;
	public ProductDetailPDFImpl(CategoryDAO categoryDao,String selectedCategory) {
		this.selectedCategory = selectedCategory;
		this.categoryDao = categoryDao;
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Font titleFont = new Font(Font.TIMES_ROMAN, 24, Font.BOLD);
		Paragraph title = new Paragraph("List of Products", titleFont );
		Font prodTitleFont = new Font(Font.TIMES_ROMAN, 18, Font.BOLD);
		document.add(title);
		String cat = selectedCategory;
		try {
			List<Product> prodList = categoryDao.prodList(cat);
			for(Product p: prodList) {
				 document.add(new Phrase("Name	"+p.getProdName(),prodTitleFont)) ;
				 document.add(new Phrase("	Price "+p.getProdPrice()));
				 document.add(new Phrase("	Quantity	"+String.valueOf(p.getProdQty())));
				 document.add(new Phrase("	Number of times User Viewed this product	"+String.valueOf(p.getUserViewCount())));
				 document.add( Chunk.NEWLINE );
				 document.add( Chunk.NEWLINE );
			}
			
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
}
