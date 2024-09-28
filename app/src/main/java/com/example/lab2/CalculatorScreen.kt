package com.example.lab2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab2.components.ComponentsRow
import com.example.lab2.components.MainButton
import com.example.lab2.components.ResultRow
import com.example.lab2.ui.theme.Lab2Theme

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {
    val calculationResult by viewModel.calculationResult.observeAsState()
    val coalModel by viewModel.grossEmissionOfSolidPartCoal.observeAsState()
    val oilModel by viewModel.grossEmissionOfSolidPartOilFuel.observeAsState()
    val gasModel by viewModel.grossEmissionOfSolidPartGas.observeAsState()

    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        Box(modifier = Modifier.padding(top = 30.dp, start = 10.dp)) {
            Column {
                Text(text = "При спалюванні вугілля")
                ComponentsRow(
                    onQValChanged = { value, type -> viewModel.updateQri(value, type) },
                    onaValChanged = { value, type -> viewModel.updateA(value, type) },
                    onAValChanged = { value, type -> viewModel.updateAr(value, type) },
                    onGValChanged = { value, type -> viewModel.updateG(value, type) },
                    onnValChanged = { value, type -> viewModel.updateN(value, type) },
                    onBValChanged = {value, type -> viewModel.updateB(value, type)},
                    qValue = coalModel!!.Qri.toString(),
                    aValue = coalModel!!.a.toString(),
                    arValue = coalModel!!.Ar.toString(),
                    gValue = coalModel!!.G.toString(),
                    nValue = coalModel!!.n.toString(),
                    bValue = coalModel!!.B.toString(),
                    type = Type.Coal
                )
            }
        }

        Box(modifier = Modifier.padding(top = 30.dp, start = 10.dp)) {
            Column {
                Text(text = "При спалюванні мазуту")
                ComponentsRow(
                    onQValChanged = { value, type -> viewModel.updateQri(value, type) },
                    onaValChanged = { value, type -> viewModel.updateA(value, type) },
                    onAValChanged = { value, type -> viewModel.updateAr(value, type) },
                    onGValChanged = { value, type -> viewModel.updateG(value, type) },
                    onnValChanged = { value, type -> viewModel.updateN(value, type) },
                    onBValChanged = {value, type -> viewModel.updateB(value, type)},
                    qValue = oilModel!!.Qri.toString(),
                    aValue = oilModel!!.a.toString(),
                    arValue = oilModel!!.Ar.toString(),
                    gValue = oilModel!!.G.toString(),
                    nValue = oilModel!!.n.toString(),
                    bValue = oilModel!!.B.toString(),
                    type = Type.FuelOil
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp)
        ) {
            MainButton(onClick = { viewModel.onCountButtonPressed() }, buttonText = "Обчислити")
        }
        Box(modifier = Modifier.padding(top = 30.dp, start = 10.dp)) {
            Column {
                ResultRow(isK = true, element = "вугілля", result = calculationResult!!.kCoal)
                ResultRow(isK = false, element = "вугілля", result = calculationResult!!.ECoal)
                ResultRow(isK = true, element = "мазуту", result = calculationResult!!.kOilFuel)
                ResultRow(isK = false, element = "мазуту", result = calculationResult!!.EOilFuel)
                ResultRow(
                    isK = true,
                    element = "природного газу: ",
                    result = calculationResult!!.kGas
                )
                ResultRow(
                    isK = false,
                    element = "природного газу: ",
                    result = calculationResult!!.EGas
                )
            }
        }
    }
}


@Preview
@Composable
fun BuildPreview() {
    Lab2Theme {
        Scaffold { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                CalculatorScreen(viewModel = CalculatorViewModel())
            }
        }

    }
}