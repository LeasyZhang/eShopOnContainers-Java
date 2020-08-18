package com.eshop.api.catalog.model;

import com.eshop.api.catalog.exception.CatalogDomainException;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table("catalog_item")
public class CatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "price")
    public BigDecimal price;

    @Column(name = "picture_file_name")
    public String pictureFileName;

    @Column(name = "picture_uri")
    public String pictureUri;

    @Column(name = "catalog_type_id")
    public Long catalogTypeId;

    @Column(name = "catalog_type")
    public String catalogType;

    @Column(name = "catalog_brand_id")
    public Long catalogBrandId;

    @Column(name = "catalog_brand")
    public String catalogBrand;

    // Quantity in stock
    @Column(name = "available_stock")
    public Integer availableStock;

    // Available stock at which we should reorder
    @Column(name = "restock_threshold")
    public Integer restockThreshold;

    // Maximum number of units that can be in-stock at any time (due to physicial/logistical constraints in warehouses)
    @Column(name = "max_stock_threshold")
    public Integer maxStockThreshold;

    /// <summary>
    /// True if item is on reorder
    /// </summary>
    @Column(name = "on_reorder")
    public Boolean onReorder;


    /// <summary>
    /// Decrements the quantity of a particular item in inventory and ensures the restockThreshold hasn't
    /// been breached. If so, a RestockRequest is generated in CheckThreshold.
    ///
    /// If there is sufficient stock of an item, then the integer returned at the end of this call should be the same as quantityDesired.
    /// In the event that there is not sufficient stock available, the method will remove whatever stock is available and return that quantity to the client.
    /// In this case, it is the responsibility of the client to determine if the amount that is returned is the same as quantityDesired.
    /// It is invalid to pass in a negative number.
    /// </summary>
    /// <param name="quantityDesired"></param>
    /// <returns>int: Returns the number actually removed from stock. </returns>
    ///
    public int removeStock(int quantityDesired) {
        if (availableStock == 0) {
            throw new CatalogDomainException("Empty stock, product item " + this.name + " is sold out");
        }

        if (quantityDesired <= 0) {
            throw new CatalogDomainException("Item units desired should be greater than zero");
        }

        int removed = Math.min(quantityDesired, this.availableStock);

        this.availableStock -= removed;

        return removed;
    }

    /// <summary>
    /// Increments the quantity of a particular item in inventory.
    /// <param name="quantity"></param>
    /// <returns>int: Returns the quantity that has been added to stock</returns>
    /// </summary>
    public int addStock(int quantity) {
        int original = this.availableStock;

        // The quantity that the client is trying to add to stock is greater than what can be physically accommodated in the Warehouse
        if ((this.availableStock + quantity) > this.maxStockThreshold) {
            // For now, this method only adds new units up maximum stock threshold. In an expanded version of this application, we
            //could include tracking for the remaining units and store information about overstock elsewhere.
            this.availableStock += (this.maxStockThreshold - this.availableStock);
        } else {
            this.availableStock += quantity;
        }

        this.onReorder = false;

        return this.availableStock - original;
    }

    public void fillImageUrl(String imageBaseUrl) {
        this.pictureUri = imageBaseUrl + this.id;
    }
}
