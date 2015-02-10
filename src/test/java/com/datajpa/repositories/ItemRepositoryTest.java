package com.datajpa.repositories;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.datajpa.Item;
import com.datajpa.ItemId;
import com.datajpa.ItemSite;
import com.datajpa.ItemSiteId;
import com.datajpa.SalesDevice;
import com.datajpa.Site;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemRepositoryTest.
 */
@ContextConfiguration(locations = { "classpath:/META-INF/test-applicationContext.xml" })
public class ItemRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired private SiteRepository siteRepository;

	@Autowired private SalesDeviceRepository salesDeviceRepository;

	/** The Item repository. */
	@Autowired private ItemRepository itemRepository;

	@Autowired private ItemSiteRepository itemSiteRepository;

	/** The item. */
	private Item item;

	/**
	 * Before test.
	 */
	@Before
	public void beforeTest() {}

	/**
	 * Test set get delete.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSetGetDelete() throws Exception {
		// save objects with single primary key
		Site site = new Site();
		site = siteRepository.save(site);

		SalesDevice sd = new SalesDevice();
		sd.setSite(site);
		sd = salesDeviceRepository.save(sd);

		// save object with simple compound key composed of two Integers
		// This uses the ItemId ID Class which contains 2 integers, one
		// for id and the other for sales_device
		item = new Item();
		item.setSalesDevice(sd);
		item = itemRepository.save(item);

		assertNotNull(item);
		assertNotNull(item.getId());

		ItemSite itemSite = new ItemSite();
		itemSite.setItem(item);
		itemSite.setSite(site);

		// save object with complex compound key composed of one Integer and
		// another nested compound key identity class.
		// This uses ItemSiteId which contains one Integer for the site ID,
		// and ItemId (which is a compound key).

		// Here the exception is thrown because the Integer data is attempting to be set to
		// the ItemId item field. The code is assuming the field to be numeric and it is not
		// supporting the concept of nested id classes.

		// Example 5.6 http://openjpa.apache.org/builds/2.2.2/apache-openjpa/docs/ref_guide_pc_oid.html
		// Taken from this site:
		// "In the example above, if Order had used an identity class OrderId in place of a simple long
		// value, then the LineItemId.order field would have been of type OrderId."
		//
		// This example shows nested identity classes as I am attempting to use here.

		itemSite = itemSiteRepository.save(itemSite); // exception

		ItemSite result = itemSiteRepository.findOne(new ItemSiteId(
				new ItemId(item.getId(), item.getSalesDevice().getId()), site.getId()));

		System.out.printf("%s%n", result);

		assertNotNull(result);
	}

}
