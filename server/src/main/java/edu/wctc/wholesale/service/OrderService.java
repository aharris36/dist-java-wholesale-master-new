package edu.wctc.wholesale.service;

import edu.wctc.wholesale.entity.Customer;
import edu.wctc.wholesale.entity.Product;
import edu.wctc.wholesale.entity.WholesaleOrder;
import edu.wctc.wholesale.dto.WholesaleOrderDto;
import edu.wctc.wholesale.exception.ResourceNotFoundException;
import edu.wctc.wholesale.repo.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderService(OrderRepository stockPurchaseRepository, ModelMapper modelMapper) {
        this.orderRepository = stockPurchaseRepository;
        this.modelMapper = modelMapper;
    }

    public List<WholesaleOrderDto> findAll() {
        List<WholesaleOrderDto> list = new ArrayList<>();
        orderRepository.findAll().forEach(order -> {
            list.add(convertToDto(order));
        });
        return list;
    }

    public WholesaleOrderDto findById(int id) {
        WholesaleOrder order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("StockPurchase", id));
        return convertToDto(order);
    }

    private WholesaleOrderDto convertToDto(WholesaleOrder entityOrder) {
        WholesaleOrderDto dtoOrder = modelMapper.map(entityOrder, WholesaleOrderDto.class);
        return dtoOrder;
    }

}
