package com.example.roomform.ui.user

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomform.data.local.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow

// Asume que la dependencia de hilt está configurada correctamente
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    // Usa hiltViewModel() para obtener el ViewModel inyectado
    viewModel: UserViewModel = hiltViewModel()
) {
    // 1. Obtener los estados reactivos del ViewModel (como se indica en tu diseño)
    val formState by viewModel.formState.collectAsState()
    val users by viewModel.users.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Registro y Lista de Usuarios") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            // Sección superior: Formulario y Mensajes
            FormSection(
                formState = formState,
                onNameChange = viewModel::onNameChange,
                onAgeChange = viewModel::onAgeChange,
                onEmailChange = viewModel::onEmailChange,
                onSaveClick = viewModel::saveUser
            )

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            // Sección inferior: Lista de Usuarios
            Text(
                text = "Usuarios Almacenados (${users.size})",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            UserListSection(users = users)
        }
    }
}

@Composable
fun FormSection(
    formState: UserFormState,
    onNameChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onSaveClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- 3 TextField: nombre, edad, email ---

        OutlinedTextField(
            value = formState.name,
            onValueChange = onNameChange,
            label = { Text("Nombre") },
            enabled = !formState.isSaving,
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        )

        OutlinedTextField(
            value = formState.age,
            onValueChange = onAgeChange,
            label = { Text("Edad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            enabled = !formState.isSaving,
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        )

        OutlinedTextField(
            value = formState.email,
            onValueChange = onEmailChange,
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            enabled = !formState.isSaving,
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- Botón Guardar (deshabilitado durante guardado) ---
        Button(
            onClick = onSaveClick,
            // Deshabilitado si está guardando (isSaving: true)
            enabled = !formState.isSaving,
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            if (formState.isSaving) {
                // Indicador de progreso durante el guardado
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = Color.White,
                    strokeWidth = 2.dp
                )
            } else {
                Text("Guardar")
            }
        }

        // --- Mensajes de error / éxito ---

        formState.errorMessage?.let { message ->
            StatusMessage(message = message, isError = true)
        }

        formState.successMessage?.let { message ->
            StatusMessage(message = message, isError = false)
        }
    }
}

@Composable
fun UserListSection(users: List<UserEntity>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (users.isEmpty()) {
            item {
                Text(
                    text = "No hay usuarios registrados.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp)
                )
            }
        } else {
            items(users, key = { it.id }) { user ->
                UserCard(user = user)
            }
        }
    }
}

@Composable
fun UserCard(user: UserEntity) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = user.email,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Text(
                text = "${user.age} años",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun StatusMessage(message: String, isError: Boolean) {
    val color = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
    val icon = if (isError) Icons.Default.Clear else Icons.Default.Done

    Card(
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f)),
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = if (isError) "Error" else "Éxito",
                tint = color,
                modifier = Modifier.size(20.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = message,
                color = color,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

