package logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.HashSet;
import java.util.Set;

public class DocumentChemReagent implements Printable {

	static String date, themeName, analyzeTitle, comments, scaleNo, volume, concentration, lifeTimeF, storage,
			reagentName, batchNo, lotNo, supplier, measured, condition;

	public Set<String> hash_Set = new HashSet<String>();

	String test = "hej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hejhej hej";

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		System.out.println(hash_Set);
		if (pageIndex == 0) {
			try {
				int width = (int) (8.5 * 72);
				int height = 72;

				// create a yellow bufferedimage
				BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D biG = bi.createGraphics();
				biG.setColor(Color.yellow);
				biG.fillRect(0, 0, width, height);

				// print the buffered image to the print graphic
				Graphics2D g2Print = (Graphics2D) graphics;
				g2Print.drawImage(bi, 0, 144, null);

				Font font = new Font("Serif", Font.PLAIN, 12);
				g2Print.setFont(font);
				g2Print.setColor(Color.black);

//				static String date, themeName, analyzeTitle, comments, scaleNo, volume, concentration, lifeTimeF, storage,
//				reagentName, batchNo, lotNo, supplier, measured, condition;

				
				
//        FontMetrics fontMetrics = g2d.getFontMetrics();
//        double titleX = (pageFormat.getImageableWidth() / 2)
//            - (fontMetrics.stringWidth(titleText) / 2);
//        double titleY = 3 * POINTS_PER_INCH;

//        for (int i=0; i<500; i+=12)
//          g2Print.drawString("(" + i + ", " + i + ")", i, i);
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
				

//        g2Print.drawString(cr.analyzeTitle	, 84, 108);

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
		this.date = date;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getAnalyzeTitle() {
		return analyzeTitle;
	}

	public void setAnalyzeTitle(String analyzeTitle) {
		this.analyzeTitle = analyzeTitle;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getScaleNo() {
		return scaleNo;
	}

	public void setScaleNo(String scaleNo) {
		this.scaleNo = scaleNo;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	public String getLifeTimeF() {
		return lifeTimeF;
	}

	public void setLifeTimeF(String lifeTimeF) {
		this.lifeTimeF = lifeTimeF;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getReagentName() {
		return reagentName;
	}

	public void setReagentName(String reagentName) {
		this.reagentName = reagentName;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getMeasured() {
		return measured;
	}

	public void setMeasured(String measured) {
		this.measured = measured;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}