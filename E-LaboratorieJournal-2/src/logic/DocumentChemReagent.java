package logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class DocumentChemReagent implements Printable {

	static String date, themeName, analyzeTitle, comments, scaleNo, volume, concentration, lifeTimeF, storage,
			reagentName, batchNo, lotNo, supplier, measured, condition;

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex == 0) {
			try {

				Graphics2D g2Print = (Graphics2D) graphics;

				Font font = new Font("Serif", Font.PLAIN, 12);
				g2Print.setFont(font);
				g2Print.setColor(Color.black);
				g2Print.drawString(getThemeName(), 400, 50);
				g2Print.drawString(getAnalyzeTitle(), 400, 100);
				g2Print.drawString(getComments(), 400, 150);
				g2Print.drawString(getScaleNo(), 400, 200);
				g2Print.drawString(getVolume(), 400, 250);
				g2Print.drawString(getConcentration(), 400, 300);
				g2Print.drawString(getLifeTimeF(), 400, 350);
				g2Print.drawString(getStorage(), 400, 400);
				g2Print.drawString(getReagentName(), 400, 450);
				g2Print.drawString(getBatchNo(), 400, 500);
				g2Print.drawString(getLotNo(), 400, 550);

				return Printable.PAGE_EXISTS;
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}

		return Printable.NO_SUCH_PAGE;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		DocumentChemReagent.date = date;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		DocumentChemReagent.themeName = themeName;
	}

	public String getAnalyzeTitle() {
		return analyzeTitle;
	}

	public void setAnalyzeTitle(String analyzeTitle) {
		DocumentChemReagent.analyzeTitle = analyzeTitle;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		DocumentChemReagent.comments = comments;
	}

	public String getScaleNo() {
		return scaleNo;
	}

	public void setScaleNo(String scaleNo) {
		DocumentChemReagent.scaleNo = scaleNo;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		DocumentChemReagent.volume = volume;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		DocumentChemReagent.concentration = concentration;
	}

	public String getLifeTimeF() {
		return lifeTimeF;
	}

	public void setLifeTimeF(String lifeTimeF) {
		DocumentChemReagent.lifeTimeF = lifeTimeF;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		DocumentChemReagent.storage = storage;
	}

	public String getReagentName() {
		return reagentName;
	}

	public void setReagentName(String reagentName) {
		DocumentChemReagent.reagentName = reagentName;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		DocumentChemReagent.batchNo = batchNo;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		DocumentChemReagent.lotNo = lotNo;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		DocumentChemReagent.supplier = supplier;
	}

	public String getMeasured() {
		return measured;
	}

	public void setMeasured(String measured) {
		DocumentChemReagent.measured = measured;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		DocumentChemReagent.condition = condition;
	}

}