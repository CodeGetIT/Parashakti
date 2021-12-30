package com.parashakti.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.parashakti.R

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val languages = resources.getStringArray(R.array.Easy)
        val Locality = resources.getStringArray(R.array.Locality)
        val house = resources.getStringArray(R.array.house)
        val housecondition = resources.getStringArray(R.array.housecondition)
        val ownership = resources.getStringArray(R.array.ownership)
        val standard = resources.getStringArray(R.array.standard)
        val relationship = resources.getStringArray(R.array.relationship)
        val address = resources.getStringArray(R.array.address)
        val accommodation = resources.getStringArray(R.array.accommodation)
        val exterior = resources.getStringArray(R.array.exterior)
        val earning = resources.getStringArray(R.array.earning)
        val marital = resources.getStringArray(R.array.marital)
        val education = resources.getStringArray(R.array.education)
        val neighbour = resources.getStringArray(R.array.neighbour)
        val vehicle = resources.getStringArray(R.array.vehicle)
        val political = resources.getStringArray(R.array.Political)
        val status = resources.getStringArray(R.array.status)
        val reason = resources.getStringArray(R.array.reason)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //locality spinner
        val spLocality = findViewById<Spinner>(R.id.spLocality)
        if (spLocality != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, Locality)
            spLocality.adapter = adapter

            spLocality.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //house spinner
        val spHouse = findViewById<Spinner>(R.id.spHouse)
        if (spHouse != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, house)
            spHouse.adapter = adapter

            spHouse.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //house condition spinner
        val spHouseCondition = findViewById<Spinner>(R.id.spHouseCondition)
        if (spHouseCondition != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, housecondition)
            spHouseCondition.adapter = adapter

            spHouseCondition.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //ownership spinner
        val spOwnership = findViewById<Spinner>(R.id.spOwnership)
        if (spOwnership != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, ownership)
            spOwnership.adapter = adapter

            spOwnership.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //standard spinner
        val spStandard = findViewById<Spinner>(R.id.spStandard)
        if (spStandard != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, standard)
            spStandard.adapter = adapter

            spStandard.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //relationship spinner
        val spRelationship = findViewById<Spinner>(R.id.spRelationship)
        if (spRelationship != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, relationship)
            spRelationship.adapter = adapter

            spRelationship.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //address spinner
        val spAddress = findViewById<Spinner>(R.id.spAddress)
        if (spAddress != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, address)
            spAddress.adapter = adapter

            spAddress.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //accommodation spinner
        val spAccommodation = findViewById<Spinner>(R.id.spAccommodation)
        if (spAccommodation != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, accommodation)
            spAccommodation.adapter = adapter

            spAccommodation.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //Exterior spinner
        val spExterior = findViewById<Spinner>(R.id.spExterior)
        if (spExterior != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, exterior)
            spExterior.adapter = adapter

            spExterior.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //Earning spinner
        val spEarning = findViewById<Spinner>(R.id.spEarning)
        if (spEarning != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, earning)
            spEarning.adapter = adapter

            spEarning.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //marital spinner
        val spMarital = findViewById<Spinner>(R.id.spMarital)
        if (spMarital != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, marital)
            spMarital.adapter = adapter

            spMarital.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //Eduction spinner
        val spEducation = findViewById<Spinner>(R.id.spEducation)
        if (spEducation != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, education)
            spEducation.adapter = adapter

            spEducation.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //Neighbour spinner
        val spNeighbour = findViewById<Spinner>(R.id.spNeighbour)
        if (spNeighbour != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, neighbour)
            spNeighbour.adapter = adapter

            spNeighbour.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //Vehicle spinner
        val spVehicle = findViewById<Spinner>(R.id.spVehicle)
        if (spVehicle != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, vehicle)
            spVehicle.adapter = adapter

            spVehicle.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //political spinner
        val spPolitical = findViewById<Spinner>(R.id.spPolitical)
        if (spPolitical != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, political)
            spPolitical.adapter = adapter

            spPolitical.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //status spinner
        val spstatus = findViewById<Spinner>(R.id.spstatus)
        if (spstatus != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, status)
            spstatus.adapter = adapter

            spstatus.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        //reason spinner
        val spreason = findViewById<Spinner>(R.id.spreason)
        if (spreason != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, reason)
            spreason.adapter = adapter

            spreason.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
}