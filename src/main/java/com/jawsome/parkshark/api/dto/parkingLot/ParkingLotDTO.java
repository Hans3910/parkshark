package com.jawsome.parkshark.api.dto.parkingLot;

import com.jawsome.parkshark.domain.instances.Category;
import com.jawsome.parkshark.domain.instances.ContactPerson;
import com.jawsome.parkshark.domain.instances.ParkingLotAddress;

public class ParkingLotDTO {

    private String name;
    private CategoryDTO categoryDTO;
    private int maxCapacity;
    private ContactPersonDTO contactPersonDTO;
    private ParkingLotAddressDTO parkingAddressDTO;
    private int pricePerHour;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ContactPersonDTO getContactPersonDTO() {
        return contactPersonDTO;
    }

    public void setContactPersonDTO(ContactPersonDTO contactPersonDTO) {
        this.contactPersonDTO = contactPersonDTO;
    }

    public ParkingLotAddressDTO getParkingAddressDTO() {
        return parkingAddressDTO;
    }

    public void setParkingAddressDTO(ParkingLotAddressDTO parkingAddressDTO) {
        this.parkingAddressDTO = parkingAddressDTO;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
