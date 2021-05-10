package com.game.pruebataxislibres.ui.fragment.map

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.game.pruebataxislibres.R
import com.game.pruebataxislibres.databinding.FragmentMapBinding
import com.game.pruebataxislibres.utils.Permissions
import com.game.pruebataxislibres.utils.mvp.BaseFragmentView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : BaseFragmentView<FragmentMapBinding>(R.layout.fragment_map), MapCore.View,
    OnMapReadyCallback, GoogleMap.OnMapClickListener, LocationListener {
    private var myMarker: MarkerOptions? = null
    private lateinit var locationManager: LocationManager

    companion object {
        const val REQUEST_CODE = 0
    }

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var map: GoogleMap
    private var listMarker: MutableList<MarkerOptions> = ArrayList<MarkerOptions>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingInit = FragmentMapBinding.bind(view)
        createMapFragment()
        initView()
    }

    private fun initView() {
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(this.requireActivity())
        binding.btnLocation.setOnClickListener { getLocation() }
    }

    private fun createMapFragment() {
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        enabledLocation()
        map.setOnMapClickListener(this)
    }

    private fun enabledLocation() {
        if (!::map.isInitialized) return
        if (Permissions(this.requireActivity()).isLocationPermissionGranted()) {
            binding.btnLocation.visibility = View.VISIBLE
        } else {
            Permissions(this.requireActivity()).requestLocationPermission()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                binding.btnLocation.visibility = View.VISIBLE
            } else {
                Toast.makeText(context, "Permiso de ubicación", Toast.LENGTH_LONG).show()
            }
            else -> {
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }


    override fun onMapClick(p0: LatLng?) {
        val markerOptions = p0?.let { MarkerOptions().position(it) }
        if (listMarker.size == 0) {
            map.addMarker(markerOptions)
            listMarker.add(markerOptions!!)
        }
    }

    override fun onLocationChanged(location: Location) {
        if (::map.isInitialized) {
            val favoritePlace = LatLng(location.latitude, location.longitude)
            map.animateCamera(
                CameraUpdateFactory.newLatLngZoom(favoritePlace, 16f),
                4000,
                null
            )
            if (myMarker == null) {
                val markerOptions = MarkerOptions().position(favoritePlace)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_taxi))
                map.addMarker(markerOptions)
                myMarker = markerOptions
            }
        }
    }

    private fun getLocation() {
        locationManager =
            this.requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(
                this.requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                this.requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE
            )
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
    }


}