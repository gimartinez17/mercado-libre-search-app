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


