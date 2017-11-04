package com.finanace.shreeji.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finanace.shreeji.model.Loan;
import com.finanace.shreeji.service.LoanService;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private LoanService loanService;

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public ModelAndView loanCreatePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("report/home");
		return modelAndView;
	}

	@RequestMapping(value = { "/downloadExcel" }, method = RequestMethod.GET)
	public void downloadExcel(HttpServletResponse response) {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=report.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Loan Report");
		List<Loan> loans = loanService.listAll();
		int rowNum = 0;
		sheet.createRow(rowNum++);
		Row headerRow = sheet.createRow(rowNum++);
		Cell c1 = headerRow.createCell(0);
		c1.setCellValue("Holder Name");
		c1 = headerRow.createCell(1);
		c1.setCellValue("Vehicle No");
		c1 = headerRow.createCell(2);
		c1.setCellValue("Loan Amount");
		c1 = headerRow.createCell(3);
		c1.setCellValue("Advance Amount");
		c1 = headerRow.createCell(4);
		c1.setCellValue("EMI Amount");
		c1 = headerRow.createCell(5);
		c1.setCellValue("Tenure Type");
		c1 = headerRow.createCell(6);
		c1.setCellValue("Total Tenure");
		sheet.createRow(rowNum++);
		for (Loan loan : loans) {
			Row row = sheet.createRow(rowNum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(loan.getCustomer().getName());
			cell = row.createCell(1);
			cell.setCellValue(loan.getVehicle().getNumber());
			cell = row.createCell(2);
			cell.setCellValue(loan.getLoanAmount());
			cell = row.createCell(3);
			cell.setCellValue(loan.getAdvanceAmount());
			cell = row.createCell(4);
			cell.setCellValue(loan.getEmiAmount());
			cell = row.createCell(5);
			cell.setCellValue(loan.getTenureType().name());
			cell = row.createCell(6);
			cell.setCellValue(loan.getTenureCount());
		}
		try {
			workbook.write(response.getOutputStream());
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}