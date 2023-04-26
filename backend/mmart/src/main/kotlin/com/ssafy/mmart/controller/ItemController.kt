package com.ssafy.mmart.controller

import com.ssafy.mmart.domain.ResultResponse
import com.ssafy.mmart.domain.item.Item
import com.ssafy.mmart.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/items")
class ItemController @Autowired constructor(
    val itemService: ItemService,
) {
    @GetMapping("/{itemIdx}")
    fun getItem(@PathVariable itemIdx: Int, @RequestParam userIdx: Int): ResultResponse<Item?> {
        return ResultResponse.success(itemService.getItem(itemIdx, userIdx))
    }

    @GetMapping("/barcode")
    fun getItemByBarcode(@RequestParam barcode: String): ResultResponse<Item?> {
        return ResultResponse.success(itemService.getItemByBarcode(barcode))
    }

    @GetMapping("/categories")
    fun getItemByCategory(@RequestParam userIdx: Int, categoryIdx: Int): ResultResponse<List<Item?>> {
        return ResultResponse.success(itemService.getItemByCategory(userIdx,categoryIdx))
    }

}