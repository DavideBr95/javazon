package com.generation.javazon;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.javazon.model.entities.Delivery;
import com.generation.javazon.model.entities.DeliveryItem;
import com.generation.javazon.model.entities.Item;
import com.generation.javazon.model.repositories.DeliveryItemRepository;
import com.generation.javazon.model.repositories.DeliveryRepository;
import com.generation.javazon.model.repositories.EmployeeRepository;
import com.generation.javazon.model.repositories.ItemRepository;

@SpringBootTest
class JavazonApplicationTests {

	
	
	@Autowired
    EmployeeRepository repoE;
    @Autowired
    ItemRepository repoI;
    @Autowired
    DeliveryItemRepository repoDI;
    @Autowired
    DeliveryRepository repoD;

	@Test
	void contextLoads() {

		// Employee e = new Employee();
		// e.setName("Federico");
		// e.setSurname("Galuppi");
		// e.setAddress("locker9662@gmail.com");
		// e.setRole("CEO");
		// e.setImgUrl("https://images.everyeye.it/img-notizie/death-stranding-inaugura-genere-videoludico-riflessione-kojima-v4-410417.jpg");
		// e.setDob(LocalDate.parse("1996-11-24"));
		// e.setHiredOn(LocalDate.parse("2024-02-02"));
		// e.setSecurityLevel(5);
		// e.setSalary(5000);
		// repoE.save(e);

		Item item1 = repoI.findById(1).get();

        List<DeliveryItem> mieDeliveries = item1.getDeliveryItems();
        List<Delivery> caseDoveSonoStato = item1.getDeliveryItems().stream().map(r->r.getDelivered()).toList();
        System.out.println(mieDeliveries);

        Delivery delivery1 = repoD.findById(1).get();

        List<Item> personeCheSonoStateAMilano = delivery1.getDeliveryItems().stream().map(r->r.getBought()).toList();
        System.out.println(mieDeliveries);
	}

}
