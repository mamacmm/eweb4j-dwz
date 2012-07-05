package test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import junit.framework.Assert;

import org.eweb4j.component.dwz.DWZCons;
import org.eweb4j.component.dwz.menu.MenuCons;
import org.eweb4j.component.dwz.menu.navmenu.NavMenuCons;
import org.eweb4j.component.dwz.menu.treemenu.TreeMenuCons;
import org.eweb4j.config.EWeb4JConfig;
import org.eweb4j.mvc.action.ActionProp;
import org.eweb4j.mvc.view.DataAssemUtil;
import org.eweb4j.mvc.view.ListPage;
import org.junit.BeforeClass;
import org.junit.Test;

import test.po.Master;
import test.po.Pet;

public class DWZTest {
	@BeforeClass
	public static void prepare() throws Exception {
		String err = EWeb4JConfig.start("start.eweb.xml");
		if (err != null) {
			System.out.println(">>>EWeb4J Start Error --> " + err);
			System.exit(-1);
		}
	}

	@Test
	public void test() throws Exception {
		Hashtable<String, String> map = new Hashtable<String, String>();
		map.put("name", "petName,300");
		map.put("age", "petAge,500");
		map.put("master.name", "masterName,200");
		ActionProp prop = new ActionProp();
		prop.setMap(map);
		List<Pet> pojos = new ArrayList<Pet>();
		Pet pet = new Pet();
		pet.setAge(5);
		pet.setPetId(20);
		pet.setName("xxx");
		pet.setNumber("D123");
		pet.setType("dog");
		Master master = new Master();
		master.setName("weiwei");
		master.setId(8);
		master.setGender("men");
		pet.setMaster(master);
		pojos.add(pet);

		ListPage listPage = new ListPage("pet", null, null, null);
		DataAssemUtil.assemHead(listPage, pojos, prop.getMap());
		System.out.println(listPage);
	}

	@Test
	public void testDWZCons() throws Exception {
		Assert.assertNotNull(DWZCons.DIV_PAGE_BTN_MAX_SHOW());
		Assert.assertNotNull(DWZCons.ERROR_ATTR_NAME());
		Assert.assertNotNull(DWZCons.ERROR_PAGE());
		Assert.assertNotNull(DWZCons.IOC_DWZ_BEAN_ID());
	}

	@Test
	public void testMenuCons() throws Exception {
		Assert.assertNotNull(MenuCons.DUP_MENU_NAME_MESS());
		Assert.assertNotNull(MenuCons.INVALID_PARENT_MESS());
		Assert.assertNotNull(MenuCons.MENU_NOT_FOUND_MESS());
		Assert.assertNotNull(MenuCons.NAV_MENU_NOT_FOUND_MESS());
		Assert.assertNotNull(MenuCons.PARENT_MENU_NOT_FOUND_MESS());
	}

	@Test
	public void testNavMenuCons() throws Exception {
		Assert.assertNotNull(NavMenuCons.DWZ_SUCCESS_JSON_CLOSE_CURRENT());
		Assert.assertNotNull(NavMenuCons.DWZ_SUCCESS_JSON_RELOAD_NAVTAB());
		Assert.assertNotNull(NavMenuCons.IOC_SERVICE_BEAN_ID());
		Assert.assertNotNull(NavMenuCons.MODEL_NAME());
		Assert.assertNotNull(NavMenuCons.DEFAULT_NAV_MENU_HREF());
		Assert.assertNotNull(NavMenuCons.DEFAULT_NAV_MENU_NAME());
		Assert.assertNotNull(NavMenuCons.DEFAULT_NAV_MENU_NAME());
	}

	@Test
	public void testTreeMenuCons() throws Exception {
		Assert.assertNotNull(TreeMenuCons.DWZ_SUCCESS_JSON_CLOSE_CURRENT());
		Assert.assertNotNull(TreeMenuCons.DWZ_SUCCESS_JSON_RELOAD_NAVTAB());
		Assert.assertNotNull(TreeMenuCons.IOC_SERVICE_BEAN_ID());
		Assert.assertNotNull(TreeMenuCons.MODEL_NAME());
		Assert.assertNotNull(TreeMenuCons.TOP_TREE_MENU_NAME());
		Assert.assertTrue(TreeMenuCons.TOP_TREE_MENU_ID() > 0);
	}

}
