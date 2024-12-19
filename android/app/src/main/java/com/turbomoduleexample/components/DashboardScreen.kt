package com.turbomoduleexample.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Autorenew
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.turbomoduleexample.utils.APIState
import com.turbomoduleexample.utils.APIStateType

/*
@Composable
fun DashboardScreen() {
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Dashboard Screen",
            style = MaterialTheme.typography.displaySmall
        )
        AssistChip(
            label = {
                Text(text = if(APIState.allGroupCall == APIStateType.loading) "All Group Loading" else "All Group Done")
            },
            enabled = true,
            leadingIcon =  {
                Icon(
                    imageVector = if(APIState.allGroupCall == APIStateType.loading) Icons.Outlined.Autorenew else Icons.Outlined.CheckCircle,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Gray,
                )
            },
            shape = AssistChipDefaults.shape,
            onClick = {}
        )

        AssistChip(
            label = {
                Text(text = if(APIState.accountDetailsCall == APIStateType.loading) "Account Details Loading" else "Account Details Done")
            },
            enabled = true,
            leadingIcon =  {
                Icon(
                    imageVector = if(APIState.accountDetailsCall == APIStateType.loading) Icons.Outlined.Autorenew else Icons.Outlined.CheckCircle,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Gray,
                )
            },
            shape = AssistChipDefaults.shape,
            onClick = {}
        )

        AssistChip(
            label = {
                Text(text = if(APIState.groupDetailsCall == APIStateType.loading) "Group Details Loading" else "Group Details Done")
            },
            enabled = true,
            leadingIcon =  {
                Icon(
                    imageVector = if(APIState.groupDetailsCall == APIStateType.loading) Icons.Outlined.Autorenew else Icons.Outlined.CheckCircle,
                    contentDescription = "Expand/Collapse",
                    tint = Color.Gray,
                )
            },
            shape = AssistChipDefaults.shape,
            onClick = {}
        )
    }
}*/

/*@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Add some padding for better appearance
        verticalArrangement = Arrangement.SpaceBetween, // Space between title and chips
        horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
    ) {
        // Title section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp), // Adjust top padding to move the title down
            horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
        ) {
            Text(
                text = "Dashboard Screen",
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center
            )
        }

        // Spacer to create space between title and chips
        Spacer(modifier = Modifier.weight(1f))

        // Chips section (centered in the remaining space)
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AssistChip(
                label = {
                    Text(
                        text = if (APIState.allGroupCall == APIStateType.loading)
                            "All Group Loading" else "All Group Done"
                    )
                },
                enabled = true,
                leadingIcon = {
                    Icon(
                        imageVector = if (APIState.allGroupCall == APIStateType.loading)
                            Icons.Outlined.Autorenew else Icons.Outlined.CheckCircle,
                        contentDescription = "Expand/Collapse",
                        tint = Color.Gray
                    )
                },
                shape = AssistChipDefaults.shape,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(16.dp)) // Add spacing between chips
            AssistChip(
                label = {
                    Text(
                        text = if (APIState.accountDetailsCall == APIStateType.loading)
                            "Account Details Loading" else "Account Details Done"
                    )
                },
                enabled = true,
                leadingIcon = {
                    Icon(
                        imageVector = if (APIState.accountDetailsCall == APIStateType.loading)
                            Icons.Outlined.Autorenew else Icons.Outlined.CheckCircle,
                        contentDescription = "Expand/Collapse",
                        tint = Color.Gray
                    )
                },
                shape = AssistChipDefaults.shape,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(16.dp)) // Add spacing between chips
            AssistChip(
                label = {
                    Text(
                        text = if (APIState.groupDetailsCall == APIStateType.loading)
                            "Group Details Loading" else "Group Details Done"
                    )
                },
                enabled = true,
                leadingIcon = {
                    Icon(
                        imageVector = if (APIState.groupDetailsCall == APIStateType.loading)
                            Icons.Outlined.Autorenew else Icons.Outlined.CheckCircle,
                        contentDescription = "Expand/Collapse",
                        tint = Color.Gray
                    )
                },
                shape = AssistChipDefaults.shape,
                onClick = {}
            )
        }

        // Spacer at the bottom to push chips to the center
        Spacer(modifier = Modifier.weight(1f))
    }
}*/

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Dashboard Screen",
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Chips section
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // All Group Call Chip
            DynamicAssistChip(
                state = APIState.allGroupCall,
                loadingLabel = "All Group Loading",
                doneLabel = "All Group Done"
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Account Details Chip
            DynamicAssistChip(
                state = APIState.accountDetailsCall,
                loadingLabel = "Account Details Loading",
                doneLabel = "Account Details Done"
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Group Details Chip
            DynamicAssistChip(
                state = APIState.groupDetailsCall,
                loadingLabel = "Group Details Loading",
                doneLabel = "Group Details Done"
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
fun DynamicAssistChip(
    state: APIStateType,
    loadingLabel: String,
    doneLabel: String
) {
    val isDone = state == APIStateType.done

    // Dynamically change colors based on the state
    val chipColor = if (isDone) Color.Green else Color.Gray
    val textColor = if (isDone) Color.Green else MaterialTheme.colorScheme.onSurface

    AssistChip(
        label = {
            Text(
                text = if (isDone) doneLabel else loadingLabel,
                color = textColor
            )
        },
        enabled = true,
        leadingIcon = {
            Icon(
                imageVector = if (isDone) Icons.Outlined.CheckCircle else Icons.Outlined.Autorenew,
                contentDescription = "State Icon",
                tint = chipColor
            )
        },
        shape = AssistChipDefaults.shape,
        colors = AssistChipDefaults.assistChipColors(
            containerColor = Color.Transparent, // Transparent background for the chip
            leadingIconContentColor = chipColor,
            labelColor = textColor,
            disabledContainerColor = Color.Gray
        ),
        border = BorderStroke(1.dp, chipColor), // Use BorderStroke directly
        onClick = {}
    )
}