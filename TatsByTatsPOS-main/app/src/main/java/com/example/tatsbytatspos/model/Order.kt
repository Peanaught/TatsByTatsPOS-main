package com.example.tatsbytatspos.model

import java.io.Serializable
import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus = OrderStatus.PENDING
)

enum class OrderStatus {
    PENDING,
    COMPLETED,
    CANCELED
}

data class OrderItem(
    val productId: String,
    val productName: String,
    val price: Double,
    var quantity: Int,
    val imageUrl: String? = null
) : Serializable

package com.example.tatsbytatspos.model

import java.util.Date
import java.util.UUID

data class Order(
    val orderId: String = UUID.randomUUID().toString(),
    val orderDate: Date = Date(),
    val items: List<OrderItem>,
    val totalAmount: Double,