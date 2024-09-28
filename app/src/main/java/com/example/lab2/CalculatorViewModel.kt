package com.example.lab2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab2.models.CalculationResult
import com.example.lab2.models.GrossEmissionOfSolidParticlesModel
import com.example.lab2.models.GrossEmissionWhileBurningModel
import kotlin.math.pow

enum class Type { Coal, FuelOil, Gas }

class CalculatorViewModel : ViewModel() {
    private val _grossEmissionOfSolidPartCoal =
        MutableLiveData(
            GrossEmissionOfSolidParticlesModel(
                20.47,
                0.8,
                25.2,
                1.5,
                0.985,
                0.0,
                526603.46
            )
        )
    private val _grossEmissionOfSolidPartOilFuel =
        MutableLiveData(
            GrossEmissionOfSolidParticlesModel(
                39.48,
                1.0,
                0.15,
                0.0,
                0.985,
                0.0,
                140032.85
            )
        )

    private val _grossEmissionOfSolidPartGas =
        MutableLiveData(
            GrossEmissionOfSolidParticlesModel(
                39.48,
                1.0,
                0.15,
                0.0,
                0.985,
                0.0,
                158540.08
            )
        )

    val grossEmissionOfSolidPartCoal: LiveData<GrossEmissionOfSolidParticlesModel> =
        _grossEmissionOfSolidPartCoal

    val grossEmissionOfSolidPartOilFuel: LiveData<GrossEmissionOfSolidParticlesModel> =
        _grossEmissionOfSolidPartOilFuel

    val grossEmissionOfSolidPartGas: LiveData<GrossEmissionOfSolidParticlesModel> =
        _grossEmissionOfSolidPartGas

    fun updateQri(value: String, type: Type = Type.Coal) {
        when (type) {
            Type.Coal -> _grossEmissionOfSolidPartCoal.value =
                _grossEmissionOfSolidPartCoal.value!!.copy(Qri = value.toDoubleOrNull() ?: 0.0)

            Type.FuelOil -> _grossEmissionOfSolidPartOilFuel.value =
                _grossEmissionOfSolidPartOilFuel.value!!.copy(Qri = value.toDoubleOrNull() ?: 0.0)

            Type.Gas -> _grossEmissionOfSolidPartGas.value =
                _grossEmissionOfSolidPartGas.value!!.copy(Qri = value.toDoubleOrNull() ?: 0.0)
        }
    }

    fun updateB(value: String, type: Type = Type.Coal) {
        when (type) {
            Type.Coal -> _grossEmissionOfSolidPartCoal.value =
                _grossEmissionOfSolidPartCoal.value!!.copy(B = value.toDoubleOrNull() ?: 0.0)

            Type.FuelOil -> _grossEmissionOfSolidPartOilFuel.value =
                _grossEmissionOfSolidPartOilFuel.value!!.copy(B = value.toDoubleOrNull() ?: 0.0)

            Type.Gas -> _grossEmissionOfSolidPartGas.value =
                _grossEmissionOfSolidPartGas.value!!.copy(B = value.toDoubleOrNull() ?: 0.0)
        }
    }


    fun updateA(value: String, type: Type) {
        when (type) {
            Type.Coal -> _grossEmissionOfSolidPartCoal.value =
                _grossEmissionOfSolidPartCoal.value!!.copy(a = value.toDoubleOrNull() ?: 0.0)

            Type.FuelOil -> _grossEmissionOfSolidPartOilFuel.value =
                _grossEmissionOfSolidPartOilFuel.value!!.copy(a = value.toDoubleOrNull() ?: 0.0)

            Type.Gas -> _grossEmissionOfSolidPartGas.value =
                _grossEmissionOfSolidPartGas.value!!.copy(a = value.toDoubleOrNull() ?: 0.0)
        }
    }

    fun updateAr(value: String, type: Type) {
        when (type) {
            Type.Coal -> _grossEmissionOfSolidPartCoal.value =
                _grossEmissionOfSolidPartCoal.value!!.copy(Ar = value.toDoubleOrNull() ?: 0.0)

            Type.FuelOil -> _grossEmissionOfSolidPartOilFuel.value =
                _grossEmissionOfSolidPartOilFuel.value!!.copy(Ar = value.toDoubleOrNull() ?: 0.0)

            Type.Gas -> _grossEmissionOfSolidPartGas.value =
                _grossEmissionOfSolidPartGas.value!!.copy(Ar = value.toDoubleOrNull() ?: 0.0)
        }
    }

    fun updateG(value: String, type: Type) {
        when (type) {
            Type.Coal -> _grossEmissionOfSolidPartCoal.value =
                _grossEmissionOfSolidPartCoal.value!!.copy(G = value.toDoubleOrNull() ?: 0.0)

            Type.FuelOil -> _grossEmissionOfSolidPartOilFuel.value =
                _grossEmissionOfSolidPartOilFuel.value!!.copy(G = value.toDoubleOrNull() ?: 0.0)

            Type.Gas -> _grossEmissionOfSolidPartGas.value =
                _grossEmissionOfSolidPartGas.value!!.copy(G = value.toDoubleOrNull() ?: 0.0)
        }
    }

    fun updateN(value: String, type: Type) {
        when (type) {
            Type.Coal -> _grossEmissionOfSolidPartCoal.value =
                _grossEmissionOfSolidPartCoal.value!!.copy(n = value.toDoubleOrNull() ?: 0.0)

            Type.FuelOil -> _grossEmissionOfSolidPartOilFuel.value =
                _grossEmissionOfSolidPartOilFuel.value!!.copy(n = value.toDoubleOrNull() ?: 0.0)

            Type.Gas -> _grossEmissionOfSolidPartGas.value =
                _grossEmissionOfSolidPartGas.value!!.copy(n = value.toDoubleOrNull() ?: 0.0)
        }
    }


    private val _calculationResult = MutableLiveData(CalculationResult())
    val calculationResult: LiveData<CalculationResult> = _calculationResult

    fun onCountButtonPressed() {
        _calculationResult.value = calculateResult(
            _grossEmissionOfSolidPartCoal.value!!,
            _grossEmissionOfSolidPartOilFuel.value!!,
            _grossEmissionOfSolidPartGas.value!!,
        )
    }

    private fun calculateResult(
        solidModelCoal: GrossEmissionOfSolidParticlesModel,
        solidModelOilFuel: GrossEmissionOfSolidParticlesModel,
        solidModelGas: GrossEmissionOfSolidParticlesModel,
    ): CalculationResult {
        val kCoal = calculateGrossEmissionOfSolidParticles(
            solidModelCoal
        )
        val ECoal = calculateGrossEmissionWhileBurning(
            GrossEmissionWhileBurningModel(
                kCoal,
                solidModelCoal.Qri,
                solidModelCoal.B,
            )
        )
        val kOilFuel = calculateGrossEmissionOfSolidParticles(
            solidModelOilFuel
        )
        val EOilFuel = calculateGrossEmissionWhileBurning(
            GrossEmissionWhileBurningModel(
                kOilFuel,
                solidModelOilFuel.Qri,
                solidModelOilFuel.B
            )
        )
        val kGas = calculateGrossEmissionOfSolidParticles(
            solidModelGas
        )
        val EGas = calculateGrossEmissionWhileBurning(
            GrossEmissionWhileBurningModel(
                kGas,
                solidModelGas.Qri,
                solidModelGas.B
            )
        )
        return CalculationResult(
            kCoal = kCoal,
            ECoal = ECoal,
            kOilFuel = kOilFuel,
            EOilFuel = EOilFuel,
            kGas = kGas,
            EGas = EGas,
        )
    }

    private fun calculateGrossEmissionOfSolidParticles(
        model: GrossEmissionOfSolidParticlesModel
    ): Double {
        return (10.0.pow(6) / model.Qri) * model.a * (model.Ar / (100 - model.G)) * (1 - model.n) + model.ks
    }

    private fun calculateGrossEmissionWhileBurning(model: GrossEmissionWhileBurningModel): Double {
        return 10.0.pow(-6) * model.k * model.Qri * model.B
    }

}