/*
 * Copyright 2018 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package urls

import controllers.ExternalUrls

trait PaymentsUrlBuilder {

  val relativeBaseUrl = "/pay-online"
  val host: String

  lazy val fullUrlForCorporationTaxMakeAPaymentPage = fullUrlForMakeAPaymentPage("corporation-tax")
  def fullUrlForSelfAssessmentMakeAPaymentPage(isBta: Boolean = true) = fullUrlForMakeAPaymentPage("self-assessment", isBta)
  lazy val fullUrlForVATMakeAPaymentPage = fullUrlForMakeAPaymentPage("vat")
  lazy val fullUrlForOtherMakeAPaymentPage = s"$host$relativeBaseUrl/other-taxes"

  private def fullUrlForMakeAPaymentPage(taxType: String, isBta: Boolean = true) = s"$host$relativeBaseUrl/$taxType/make-a-payment?mode=" + (if(isBta) "bta" else "pta")

}

object PaymentsUrlBuilder extends PaymentsUrlBuilder {
  override lazy val host = ExternalUrls.paymentsHost
}
