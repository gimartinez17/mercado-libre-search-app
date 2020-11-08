package com.example.data

import com.example.domain.model.*


fun getSearchResultsMocked(query: String) = SearchResponse(
    query,
    getPagingDataMocked(),
    getProductListMocked()
)

fun getPagingDataMocked() = Paging(
    total = 5566,
    offset = 0,
    limit = 50
)

fun getProductListMocked() = listOf(getProductMocked())

fun getProductMocked() = Product(
    id = "MLA872599247",
    title = "Notebook Dell Intel I3 1005g1 4gb 1tb 15.6 Vostro 3591",
    price = 76440.toDouble(),
    thumbnail = "http://http2.mlstatic.com/D_891515-MLA43116996371_082020-O.jpg",
    installments = Installments(12, 70.17),
    shipping = Shipping(true, "cross_docking"),
    tags = listOf(
        "brand_verified",
        "extended_warranty_eligible",
        "good_quality_picture",
        "good_quality_thumbnail",
        "immediate_payment",
        "cart_eligible",
        "shipping_guaranteed"
    ),
    originalPrice = 110999.toDouble()
)

fun getProductMocked(id: String) = ProductDetailResponse(
    id = id,
    title = "Disco Duro Interno Western Digital  Wd10ezex 1tb Azul",
    price = 4454.toDouble(),
    originalPrice = null,
    condition = "new",
    pictures = getPicturesDataMocked(),
    availableQuantity = 250,
    soldQuantity = 500,
    shipping = getShippingDetails(),
    attribute = getAttributesDataMocked(),
    warranty = "Garantía de fábrica: 6 meses",
    health = null
)

fun getPicturesDataMocked() = listOf(
    Pictures("https://http2.mlstatic.com/D_634927-MLA40150880523_122019-O.jpg"),
    Pictures("https://http2.mlstatic.com/D_671872-MLA40662113128_022020-O.jpg"),
    Pictures("https://http2.mlstatic.com/D_652891-MLA40150893421_122019-O.jpg")
)

fun getShippingDetails() =
    ShippingDetails(
        tags = listOf("self_service_in", "mandatory_free_shipping"),
        logisticType = "cross_docking"
    )

fun getAttributesDataMocked() = listOf(
    Attribute("APPLICATIONS", "Aplicaciones", "289315", "PC"),
    Attribute("BRAND", "Marca", "9593", "Western Digital"),
    Attribute("CAPACITY", "Capacidad", "9588", "1 TB"),
    Attribute("COLOR", "Color", "52028", "Azul"),
    Attribute("DATA_CACHE", "Caché de datos", "1126292", "64MB"),
    Attribute("DEPTH", "Profundidad", "8586953", "26.1 mm"),
    Attribute("GTIN", "Código universal de producto", "NULL", "718037779911"),
    Attribute("HARD_DRIVE_FORM_FACTOR", "Factor de forma", "9049275", "3.5 \""),
    Attribute("HARD_DRIVE_LOCATION", "Ubicación del disco", "96008", "Interno"),
    Attribute("HEIGHT", "Altura", "7952488", "26.1 mm"),
    Attribute("INTERFACES", "Interfaces", "1118308", "SATA III"),
    Attribute("ITEM_CONDITION", "Condición del ítem", "2230284", "Nuevo"),
    Attribute("LINE", "Línea", "7737767", "WD Blue"),
    Attribute("MODEL", "Modelo", "7757996", "WD10EZEX"),
    Attribute("POWER_CONSUMPTION", "Consumo energético", "7001314", "2.5 W"),
    Attribute("ROTATION_SPEED", "Velocidad de rotación", "7870148", "7200 rpm"),
    Attribute("SELLER_SKU", "SKU", "718037779911", "718037779911"),
    Attribute("STORAGE_TECHNOLOGY", "Tecnología de almacenamiento", "122391", "HDD"),
    Attribute("WEIGHT", "Peso", "8223940", "0.45 kg"),
    Attribute("WIDTH", "Ancho", "8611019", "147 mm")
)

fun getSearchResponseMocked() =
    "{\"site_id\":\"MLA\",\"query\":\"dell\",\"paging\":{\"total\":5566,\"primary_results\":1000,\"offset\":0,\"limit\":50},\"results\":[{\"id\":\"MLA872599247\",\"site_id\":\"MLA\",\"title\":\"Notebook Dell Intel I3 1005g1 4gb 1tb 15.6 Vostro 3591\",\"seller\":{\"id\":174556876,\"permalink\":\"http://perfil.mercadolibre.com.ar/OVERHARD+DIGITAL\",\"registration_date\":\"2015-01-08T08:19:41.000-04:00\",\"car_dealer\":false,\"real_estate_agency\":false,\"tags\":[\"normal\",\"user_info_verified\",\"credits_priority_4\",\"eshop\",\"mshops\",\"credits_profile\",\"messages_as_seller\",\"messages_as_buyer\"],\"eshop\":{\"nick_name\":\"OVERHARD DIGITAL\",\"eshop_rubro\":null,\"eshop_id\":162995,\"eshop_locations\":[],\"site_id\":\"MLA\",\"eshop_logo_url\":\"http://resources.mlstatic.com/eshops/174556876vf25324.png\",\"eshop_status_id\":1,\"seller\":174556876,\"eshop_experience\":0},\"seller_reputation\":{\"transactions\":{\"total\":389221,\"canceled\":25107,\"period\":\"historic\",\"ratings\":{\"negative\":0.03,\"positive\":0.95,\"neutral\":0.02},\"completed\":364114},\"power_seller_status\":\"platinum\",\"metrics\":{\"claims\":{\"rate\":0.0101,\"value\":914,\"period\":\"60 days\"},\"delayed_handling_time\":{\"rate\":0.0439,\"value\":3396,\"period\":\"60 days\"},\"sales\":{\"period\":\"60 days\",\"completed\":84632},\"cancellations\":{\"rate\":0.0082,\"value\":750,\"period\":\"60 days\"}},\"level_id\":\"5_green\"}},\"price\":76440,\"prices\":{},\"sale_price\":null,\"currency_id\":\"ARS\",\"available_quantity\":1,\"sold_quantity\":100,\"buying_mode\":\"buy_it_now\",\"listing_type_id\":\"gold_special\",\"stop_time\":\"2040-08-05T04:00:00.000Z\",\"condition\":\"new\",\"permalink\":\"https://articulo.mercadolibre.com.ar/MLA-872599247-notebook-dell-intel-i3-1005g1-4gb-1tb-156-vostro-3591-_JM\",\"thumbnail\":\"http://http2.mlstatic.com/D_891515-MLA43116996371_082020-O.jpg\",\"accepts_mercadopago\":true,\"installments\":{\"quantity\":12,\"amount\":10839.83,\"rate\":70.17,\"currency_id\":\"ARS\"},\"address\":{\"state_id\":\"AR-C\",\"state_name\":\"Capital Federal\",\"city_id\":\"TUxBQlZJTDQyMjBa\",\"city_name\":\"Villa Crespo\"},\"shipping\":{\"free_shipping\":true,\"mode\":\"me2\",\"tags\":[\"self_service_in\",\"mandatory_free_shipping\"],\"logistic_type\":\"cross_docking\",\"store_pick_up\":false},\"seller_address\":{\"id\":\"\",\"comment\":\"\",\"address_line\":\"\",\"zip_code\":\"\",\"country\":{\"id\":\"AR\",\"name\":\"Argentina\"},\"state\":{\"id\":\"AR-C\",\"name\":\"Capital Federal\"},\"city\":{\"id\":\"TUxBQlZJTDQyMjBa\",\"name\":\"Villa Crespo\"},\"latitude\":\"\",\"longitude\":\"\"},\"attributes\":[{\"source\":6808261514773724,\"value_id\":\"8216\",\"value_name\":\"Dell\",\"value_struct\":null,\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\",\"id\":\"BRAND\",\"name\":\"Marca\",\"values\":[{\"source\":6808261514773724,\"id\":\"8216\",\"name\":\"Dell\",\"struct\":null}]},{\"value_id\":\"2230284\",\"value_name\":\"Nuevo\",\"value_struct\":null,\"attribute_group_name\":\"Otros\",\"id\":\"ITEM_CONDITION\",\"name\":\"Condición del ítem\",\"values\":[{\"id\":\"2230284\",\"name\":\"Nuevo\",\"struct\":null,\"source\":6808261514773724}],\"attribute_group_id\":\"OTHERS\",\"source\":6808261514773724},{\"attribute_group_id\":\"OTHERS\",\"source\":6808261514773724,\"id\":\"LINE\",\"name\":\"Línea\",\"value_name\":\"VOSTRO 3591\",\"value_struct\":null,\"values\":[{\"id\":null,\"name\":\"VOSTRO 3591\",\"struct\":null,\"source\":6808261514773724}],\"value_id\":null,\"attribute_group_name\":\"Otros\"},{\"value_name\":\"VOSTRO 3591 I3 1005G1\",\"attribute_group_name\":\"Otros\",\"id\":\"MODEL\",\"name\":\"Modelo\",\"value_id\":null,\"value_struct\":null,\"values\":[{\"struct\":null,\"source\":6808261514773724,\"id\":null,\"name\":\"VOSTRO 3591 I3 1005G1\"}],\"attribute_group_id\":\"OTHERS\",\"source\":6808261514773724},{\"id\":\"PROCESSOR_BRAND\",\"name\":\"Marca del procesador\",\"value_id\":\"7855833\",\"values\":[{\"id\":\"7855833\",\"name\":\"Intel\",\"struct\":null,\"source\":6808261514773724}],\"attribute_group_name\":\"Otros\",\"source\":6808261514773724,\"value_name\":\"Intel\",\"value_struct\":null,\"attribute_group_id\":\"OTHERS\"},{\"id\":\"PROCESSOR_LINE\",\"name\":\"Línea del procesador\",\"source\":6808261514773724,\"attribute_group_name\":\"Otros\",\"value_id\":\"7769179\",\"value_name\":\"Core i3\",\"value_struct\":null,\"values\":[{\"name\":\"Core i3\",\"struct\":null,\"source\":6808261514773724,\"id\":\"7769179\"}],\"attribute_group_id\":\"OTHERS\"},{\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\",\"source\":6808261514773724,\"name\":\"Peso\",\"value_name\":null,\"value_struct\":null,\"id\":\"WEIGHT\",\"value_id\":\"-1\",\"values\":[{\"id\":\"-1\",\"name\":null,\"struct\":null,\"source\":6808261514773724}]}],\"original_price\":110999,\"category_id\":\"MLA1652\",\"official_store_id\":null,\"domain_id\":\"MLA-NOTEBOOKS\",\"catalog_product_id\":\"MLA16050878\",\"tags\":[\"brand_verified\",\"extended_warranty_eligible\",\"good_quality_picture\",\"good_quality_thumbnail\",\"immediate_payment\",\"cart_eligible\",\"shipping_guaranteed\"],\"order_backend\":1}]}"

fun getPorductResponseMocked() = "{\"id\":\"MLA876077268\",\"site_id\":\"MLA\",\"title\":\"Disco Duro Interno Western Digital  Wd10ezex 1tb Azul\",\"subtitle\":null,\"seller_id\":203804413,\"category_id\":\"MLA1672\",\"official_store_id\":null,\"price\":4454,\"base_price\":4454,\"original_price\":null,\"currency_id\":\"ARS\",\"initial_quantity\":639,\"available_quantity\":250,\"sold_quantity\":500,\"sale_terms\":[{\"id\":\"WARRANTY_TIME\",\"name\":\"Tiempo de garantía\",\"value_id\":null,\"value_name\":\"6 meses\",\"value_struct\":{\"number\":6,\"unit\":\"meses\"},\"values\":[{\"id\":null,\"name\":\"6 meses\",\"struct\":{\"number\":6,\"unit\":\"meses\"}}]},{\"id\":\"INVOICE\",\"name\":\"Facturación\",\"value_id\":\"6891885\",\"value_name\":\"Factura A\",\"value_struct\":null,\"values\":[{\"id\":\"6891885\",\"name\":\"Factura A\",\"struct\":null}]},{\"id\":\"WARRANTY_TYPE\",\"name\":\"Tipo de garantía\",\"value_id\":\"2230279\",\"value_name\":\"Garantía de fábrica\",\"value_struct\":null,\"values\":[{\"id\":\"2230279\",\"name\":\"Garantía de fábrica\",\"struct\":null}]}],\"buying_mode\":\"buy_it_now\",\"listing_type_id\":\"gold_special\",\"start_time\":\"2020-09-01T05:09:53.000Z\",\"stop_time\":\"2040-08-27T04:00:00.000Z\",\"condition\":\"new\",\"permalink\":\"https://articulo.mercadolibre.com.ar/MLA-876077268-disco-duro-interno-western-digital-wd10ezex-1tb-azul-_JM\",\"thumbnail_id\":\"634927-MLA40150880523_122019\",\"thumbnail\":\"http://http2.mlstatic.com/D_634927-MLA40150880523_122019-I.jpg\",\"secure_thumbnail\":\"https://http2.mlstatic.com/D_634927-MLA40150880523_122019-I.jpg\",\"pictures\":[{\"id\":\"634927-MLA40150880523_122019\",\"url\":\"http://http2.mlstatic.com/D_634927-MLA40150880523_122019-O.jpg\",\"secure_url\":\"https://http2.mlstatic.com/D_634927-MLA40150880523_122019-O.jpg\",\"size\":\"348x500\",\"max_size\":\"1056x1515\",\"quality\":\"\"},{\"id\":\"671872-MLA40662113128_022020\",\"url\":\"http://http2.mlstatic.com/D_671872-MLA40662113128_022020-O.jpg\",\"secure_url\":\"https://http2.mlstatic.com/D_671872-MLA40662113128_022020-O.jpg\",\"size\":\"382x500\",\"max_size\":\"791x1034\",\"quality\":\"\"},{\"id\":\"652891-MLA40150893421_122019\",\"url\":\"http://http2.mlstatic.com/D_652891-MLA40150893421_122019-O.jpg\",\"secure_url\":\"https://http2.mlstatic.com/D_652891-MLA40150893421_122019-O.jpg\",\"size\":\"500x494\",\"max_size\":\"1214x1200\",\"quality\":\"\"}],\"video_id\":null,\"descriptions\":[{\"id\":\"MLA876077268-2890161329\"}],\"accepts_mercadopago\":true,\"non_mercado_pago_payment_methods\":[],\"shipping\":{\"mode\":\"me2\",\"free_methods\":[{\"id\":73328,\"rule\":{\"default\":true,\"free_mode\":\"country\",\"free_shipping_flag\":true,\"value\":null}}],\"tags\":[\"self_service_in\",\"mandatory_free_shipping\"],\"dimensions\":null,\"local_pick_up\":false,\"free_shipping\":true,\"logistic_type\":\"cross_docking\",\"store_pick_up\":false},\"international_delivery_mode\":\"none\",\"seller_address\":{\"city\":{\"name\":\"Nuñez\"},\"state\":{\"id\":\"AR-C\",\"name\":\"Capital Federal\"},\"country\":{\"id\":\"AR\",\"name\":\"Argentina\"},\"search_location\":{\"neighborhood\":{\"id\":\"TUxBQlBBTDI1MTVa\",\"name\":\"Palermo\"},\"city\":{\"id\":\"TUxBQ0NBUGZlZG1sYQ\",\"name\":\"Capital Federal\"},\"state\":{\"id\":\"TUxBUENBUGw3M2E1\",\"name\":\"Capital Federal\"}},\"id\":185502351},\"seller_contact\":null,\"location\":{},\"coverage_areas\":[],\"attributes\":[{\"id\":\"APPLICATIONS\",\"name\":\"Aplicaciones\",\"value_id\":\"289315\",\"value_name\":\"PC\",\"value_struct\":null,\"values\":[{\"id\":\"289315\",\"name\":\"PC\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"BRAND\",\"name\":\"Marca\",\"value_id\":\"9593\",\"value_name\":\"Western Digital\",\"value_struct\":null,\"values\":[{\"id\":\"9593\",\"name\":\"Western Digital\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"CAPACITY\",\"name\":\"Capacidad\",\"value_id\":\"9588\",\"value_name\":\"1 TB\",\"value_struct\":{\"number\":1,\"unit\":\"TB\"},\"values\":[{\"id\":\"9588\",\"name\":\"1 TB\",\"struct\":{\"number\":1,\"unit\":\"TB\"}}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"COLOR\",\"name\":\"Color\",\"value_id\":\"52028\",\"value_name\":\"Azul\",\"value_struct\":null,\"values\":[{\"id\":\"52028\",\"name\":\"Azul\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"DATA_CACHE\",\"name\":\"Caché de datos\",\"value_id\":\"1126292\",\"value_name\":\"64MB\",\"value_struct\":{\"number\":64,\"unit\":\"MB\"},\"values\":[{\"id\":\"1126292\",\"name\":\"64 MB\",\"struct\":{\"number\":64,\"unit\":\"MB\"}}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"DEPTH\",\"name\":\"Profundidad\",\"value_id\":\"8586953\",\"value_name\":\"26.1 mm\",\"value_struct\":{\"number\":26.1,\"unit\":\"mm\"},\"values\":[{\"id\":\"8586953\",\"name\":\"26.1 mm\",\"struct\":{\"number\":26.1,\"unit\":\"mm\"}}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"GTIN\",\"name\":\"Código universal de producto\",\"value_id\":\"NULL\",\"value_name\":\"718037779911\",\"value_struct\":null,\"values\":[{\"id\":\"NULL\",\"name\":\"718037779911\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"HARD_DRIVE_FORM_FACTOR\",\"name\":\"Factor de forma\",\"value_id\":\"9049275\",\"value_name\":\"3.5 \\\"\",\"value_struct\":null,\"values\":[{\"id\":\"9049275\",\"name\":\"3.5 \\\"\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"HARD_DRIVE_LOCATION\",\"name\":\"Ubicación del disco\",\"value_id\":\"96008\",\"value_name\":\"Interno\",\"value_struct\":null,\"values\":[{\"id\":\"96008\",\"name\":\"Interno\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"HEIGHT\",\"name\":\"Altura\",\"value_id\":\"7952488\",\"value_name\":\"26.1 mm\",\"value_struct\":{\"number\":26.1,\"unit\":\"mm\"},\"values\":[{\"id\":\"7952488\",\"name\":\"26.1 mm\",\"struct\":{\"number\":26.1,\"unit\":\"mm\"}}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"INTERFACES\",\"name\":\"Interfaces\",\"value_id\":\"1118308\",\"value_name\":\"SATA III\",\"value_struct\":null,\"values\":[{\"id\":\"1118308\",\"name\":\"SATA III\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"ITEM_CONDITION\",\"name\":\"Condición del ítem\",\"value_id\":\"2230284\",\"value_name\":\"Nuevo\",\"value_struct\":null,\"values\":[{\"id\":\"2230284\",\"name\":\"Nuevo\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"LINE\",\"name\":\"Línea\",\"value_id\":\"7737767\",\"value_name\":\"WD Blue\",\"value_struct\":null,\"values\":[{\"id\":\"7737767\",\"name\":\"WD Blue\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"MODEL\",\"name\":\"Modelo\",\"value_id\":\"7757996\",\"value_name\":\"WD10EZEX\",\"value_struct\":null,\"values\":[{\"id\":\"7757996\",\"name\":\"WD10EZEX\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"POWER_CONSUMPTION\",\"name\":\"Consumo energético\",\"value_id\":\"7001314\",\"value_name\":\"2.5 W\",\"value_struct\":{\"number\":2.5,\"unit\":\"W\"},\"values\":[{\"id\":\"7001314\",\"name\":\"2.5 W\",\"struct\":{\"number\":2.5,\"unit\":\"W\"}}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"ROTATION_SPEED\",\"name\":\"Velocidad de rotación\",\"value_id\":\"7870148\",\"value_name\":\"7200 rpm\",\"value_struct\":{\"number\":7200,\"unit\":\"rpm\"},\"values\":[{\"id\":\"7870148\",\"name\":\"7200 rpm\",\"struct\":{\"number\":7200,\"unit\":\"rpm\"}}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"SELLER_SKU\",\"name\":\"SKU\",\"value_id\":\"718037779911\",\"value_name\":\"718037779911\",\"value_struct\":null,\"values\":[{\"id\":\"718037779911\",\"name\":\"718037779911\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"STORAGE_TECHNOLOGY\",\"name\":\"Tecnología de almacenamiento\",\"value_id\":\"122391\",\"value_name\":\"HDD\",\"value_struct\":null,\"values\":[{\"id\":\"122391\",\"name\":\"HDD\",\"struct\":null}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"WEIGHT\",\"name\":\"Peso\",\"value_id\":\"8223940\",\"value_name\":\"0.45 kg\",\"value_struct\":{\"number\":0.45,\"unit\":\"kg\"},\"values\":[{\"id\":\"8223940\",\"name\":\"0.45 kg\",\"struct\":{\"number\":0.45,\"unit\":\"kg\"}}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"},{\"id\":\"WIDTH\",\"name\":\"Ancho\",\"value_id\":\"8611019\",\"value_name\":\"147 mm\",\"value_struct\":{\"number\":147,\"unit\":\"mm\"},\"values\":[{\"id\":\"8611019\",\"name\":\"147 mm\",\"struct\":{\"number\":147,\"unit\":\"mm\"}}],\"attribute_group_id\":\"OTHERS\",\"attribute_group_name\":\"Otros\"}],\"warnings\":[],\"listing_source\":\"\",\"variations\":[],\"status\":\"active\",\"sub_status\":[],\"tags\":[\"brand_verified\",\"dragged_bids_and_visits\",\"good_quality_picture\",\"immediate_payment\",\"cart_eligible\"],\"warranty\":\"Garantía de fábrica: 6 meses\",\"catalog_product_id\":\"MLA6241686\",\"domain_id\":\"MLA-HARD_DRIVES_AND_SSDS\",\"parent_item_id\":\"MLA864462791\",\"differential_pricing\":null,\"deal_ids\":[],\"automatic_relist\":false,\"date_created\":\"2020-09-01T05:09:53.000Z\",\"last_updated\":\"2020-11-08T03:51:27.000Z\",\"health\":null,\"catalog_listing\":true}"


