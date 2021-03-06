/*
 * EtherNet/IP
 * Copyright (C) 2014 Kevin Herron
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.digitalpetri.ethernetip.encapsulation.commands

import org.scalatest.FunSuite

class ListServicesTest extends FunSuite {

  test("ListServices request is round-trip encodable/decodable") {
    val command = ListServices()
    val decoded = ListServices.decode(ListServices.encode(command))

    assert(command == decoded)
  }

  test("ListServices response is round-trip encodable/decodable") {
    val services = Seq(
      ServiceInformation(0, 1, 2, "Service 1"),
      ServiceInformation(0, 1, 2, "Service 2"))

    val command = ListServices(services)
    val decoded = ListServices.decode(ListServices.encode(command))

    assert(command == decoded)
  }

}
