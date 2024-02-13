package com.generation.javazon.model.dtoservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.generation.javazon.model.dto.delivery.DeliveryDtoWWithItems;
import com.generation.javazon.model.dto.delivery.DeliveryDtoWWithItemsAug;
import com.generation.javazon.model.entities.Delivery;
import com.generation.javazon.model.entities.Item;

@Service
public class DeliveryConverter {

    public DeliveryDtoWWithItems DeliveryToDtoWWithItems(Delivery e)
    {
        return DeliveryDtoWWithItems
               .builder()
               .id(e.getId())
               .address(e.getAddress())
               .payment_method(e.getPayment_method())
               .delivery_date(e.getDelivery_date())
            //    .items(e.getDeliveryItems())
               .items(calcListItem(e))
               .build(); 
    }

    public DeliveryDtoWWithItemsAug DeliveryToDtoWWithItemsAug(Delivery e)
    {

        return DeliveryDtoWWithItemsAug
               .builder()
               .id(e.getId())
               .address(e.getAddress())
               .payment_method(e.getPayment_method())
               .delivery_date(e.getDelivery_date())
               .items(calcListItem(e))
               .totRevenue(calcTotRevenue(e))
               .quantity(calcQuantity(e))
               .build();
    }

    private List<Item> calcListItem(Delivery d)
    {
        return d.getDeliveryItems().stream().map(i->i.getBought()).toList();
    }

    private double calcTotRevenue(Delivery e)
    {

        if(e.getDeliveryItems()==null)
            return 0;

        double res = 0;

        for(DeliveryItem d:e.getDeliveryItems())
            res+=d.get

        // come prendere il price?
    }
}
