package com.webshop.backend.webrest;

import com.webshop.backend.exception.RecordNotFoundException;
import com.webshop.backend.model.DeliveryEntity;
import com.webshop.backend.service.DeliveryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController
{
    @Autowired
    DeliveryService service;

    @GetMapping
    public ResponseEntity<List<DeliveryEntity>> getAllDelivery() {
        List<DeliveryEntity> list = service.getAllDelivery();

        return new ResponseEntity<List<DeliveryEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryEntity> getDeliveryById(@PathVariable("id") Integer id)
        throws RecordNotFoundException {
        DeliveryEntity entity = service.getDeliveryById(id);

        return new ResponseEntity<DeliveryEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeliveryEntity> createOrUpdateDelivery(DeliveryEntity delivery)
        throws RecordNotFoundException {
        DeliveryEntity updated = service.createOrUpdateDelivery(delivery);
        return new ResponseEntity<DeliveryEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteDeliveryById(@PathVariable("id") Integer id)
        throws RecordNotFoundException {
        service.deleteDeliveryById(id);
        return HttpStatus.FORBIDDEN;
    }

}