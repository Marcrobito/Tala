package dev.eighteentech.tala.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.eighteentech.tala.entities.Item
import dev.eighteentech.tala.entities.Status.*
import dev.eighteentech.tala.entities.Status.Companion.status

@Composable
fun ItemList(content: List<Item>) {
    LazyColumn(
        contentPadding = PaddingValues(all = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(content) { item ->
            TalaCardPair(item = item)
        }
    }
}

@Composable
fun TalaCardPair(item: Item) {
    Column(modifier = Modifier.fillMaxWidth()) {
        when (status(item.loan?.status?:"")) {
            APPROVED -> ApprovedCard(item.loan!!, item.locale)
            DUE -> DueCard(loan = item.loan!!, item.locale)
            PAID -> PaidCard(item.loan!!, item.locale)
            UNKNOWN -> DummyCard(local = item.locale)
        }
        StatusCard(item.loan, item.locale)
    }
}
