package com.parashakti.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class HomeModel {
    @SerializedName("response")
    @Expose
    var response: String? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("sql")
    @Expose
    var sql: String? = null

    @SerializedName("criteria")
    @Expose
    var criteria: Int? = null

    @SerializedName("cases")
    @Expose
    var cases: List<Case>? = null

    class Case {
        @SerializedName("fld_case_id")
        @Expose
        var fldCaseId: String? = null

        @SerializedName("fld_application_id")
        @Expose
        var fldApplicationId: String? = null

        @SerializedName("fld_client_name_")
        @Expose
        var fldClientName: String? = null

        @SerializedName("fld_client_location")
        @Expose
        var fldClientLocation: String? = null

        @SerializedName("fld_case_number")
        @Expose
        var fldCaseNumber: String? = null

        @SerializedName("fld_case_location")
        @Expose
        var fldCaseLocation: String? = null

        @SerializedName("fld_customer_type")
        @Expose
        var fldCustomerType: String? = null

        @SerializedName("fld_applicant_name")
        @Expose
        var fldApplicantName: String? = null

        @SerializedName("fld_address")
        @Expose
        var fldAddress: String? = null

        @SerializedName("fld_alt_telephone")
        @Expose
        var fldAltTelephone: String? = null

        @SerializedName("fld_pda_no")
        @Expose
        var fldPdaNo: String? = null

        @SerializedName("fld_fos_name")
        @Expose
        var fldFosName: String? = null

        @SerializedName("fld_case_type")
        @Expose
        var fldCaseType: String? = null

        @SerializedName("fld_case_status")
        @Expose
        var fldCaseStatus: String? = null

        @SerializedName("fld_client_code")
        @Expose
        var fldClientCode: String? = null

        @SerializedName("fld_dealer_name")
        @Expose
        var fldDealerName: String? = null

        @SerializedName("fld_map_image")
        @Expose
        var fldMapImage: String? = null

        @SerializedName("fld_created_on")
        @Expose
        var fldCreatedOn: String? = null

        @SerializedName("fld_added_by")
        @Expose
        var fldAddedBy: String? = null

        @SerializedName("fld_agent_id")
        @Expose
        var fldAgentId: String? = null

        @SerializedName("fld_agent_name")
        @Expose
        var fldAgentName: String? = null

        @SerializedName("fld_agent_number")
        @Expose
        var fldAgentNumber: String? = null

        @SerializedName("fld_agent_email")
        @Expose
        var fldAgentEmail: String? = null

        @SerializedName("fld_agent_address")
        @Expose
        var fldAgentAddress: String? = null

        @SerializedName("fld_agent_code")
        @Expose
        var fldAgentCode: String? = null

        @SerializedName("fld_agent_password")
        @Expose
        var fldAgentPassword: String? = null

        @SerializedName("fld_agent_image")
        @Expose
        var fldAgentImage: String? = null

        @SerializedName("fld_account_name")
        @Expose
        var fldAccountName: String? = null

        @SerializedName("fld_account_number")
        @Expose
        var fldAccountNumber: String? = null

        @SerializedName("fld_bank_name")
        @Expose
        var fldBankName: String? = null

        @SerializedName("fld_ifsc_code")
        @Expose
        var fldIfscCode: String? = null

        @SerializedName("fld_last_login_ip")
        @Expose
        var fldLastLoginIp: String? = null

        @SerializedName("fld_agent_otp_verify")
        @Expose
        var fldAgentOtpVerify: String? = null

        @SerializedName("fld_client_id")
        @Expose
        var fldClientId: String? = null

        @SerializedName("fld_client_number")
        @Expose
        var fldClientNumber: String? = null

        @SerializedName("fld_client_company_name")
        @Expose
        var fldClientCompanyName: String? = null

        @SerializedName("fld_location_id")
        @Expose
        var fldLocationId: String? = null

        @SerializedName("fld_company_id")
        @Expose
        var fldCompanyId: String? = null

        @SerializedName("fld_com_location")
        @Expose
        var fldComLocation: String? = null

        @SerializedName("fld_created_at")
        @Expose
        var fldCreatedAt: String? = null
    }
}