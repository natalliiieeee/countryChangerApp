package UC5AndUC6JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import statsVisualiser.gui.MainUI;

public class MainUITest {

	@Test
	public void test1() {
		MainUI mainUI = MainUI.getInstance();
		assertEquals("+", mainUI.getAddView().getText());
		assertEquals("-", mainUI.getRemoveView().getText());
	}
	
	@Test
	public void test2() {
		MainUI mainUI = MainUI.getInstance();
		assertSame(0,mainUI.getCpList().size());
	}
	
	@Test
	public void test3() {
		MainUI mainUI = MainUI.getInstance();
		mainUI.getAddView().doClick();
		mainUI.getAddView().doClick();
		assertSame(2,mainUI.getCpList().size());
		mainUI.getRemoveView().doClick();
		assertSame(1,mainUI.getCpList().size());
	}

}
