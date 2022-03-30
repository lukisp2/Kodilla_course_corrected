package com.kodilla.kodilla.good.patterns.challenges.allegro;

public class ProductOrderService {
    private InformationService informationService;
    private PurchaseService purchaseService;
    private PurchaseRepository purchaseRepository;

    public ProductOrderService(InformationService informationService,
                               PurchaseService purchaseService,
                               PurchaseRepository purchaseRepository) {
        this.informationService = informationService;
        this.purchaseService = purchaseService;
        this.purchaseRepository = purchaseRepository;
    }

    public PurchaseDto process(PurchaseRequest purchaseRequest){

        boolean isBought = purchaseService.buy(purchaseRequest.getUser(), purchaseRequest.getProduct());
        if (isBought) {
            informationService.inform(purchaseRequest.getUser());
            purchaseRepository.createPurchase(purchaseRequest.getUser(), purchaseRequest.getProduct());
            return new PurchaseDto(purchaseRequest.getUser(),true);
        } else {
            return new PurchaseDto(purchaseRequest.getUser(),false);
        }
    }
}
