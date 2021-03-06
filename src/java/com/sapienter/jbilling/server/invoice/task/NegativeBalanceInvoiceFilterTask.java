/*
 jBilling - The Enterprise Open Source Billing System
 Copyright (C) 2003-2011 Enterprise jBilling Software Ltd. and Emiliano Conde

 This file is part of jbilling.

 jbilling is free software: you can redistribute it and/or modify
 it under the terms of the GNU Affero General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 jbilling is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Affero General Public License for more details.

 You should have received a copy of the GNU Affero General Public License
 along with jbilling.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.sapienter.jbilling.server.invoice.task;

import com.sapienter.jbilling.server.invoice.db.InvoiceDTO;
import com.sapienter.jbilling.server.pluggableTask.InvoiceFilterTask;
import com.sapienter.jbilling.server.pluggableTask.PluggableTask;
import com.sapienter.jbilling.server.pluggableTask.TaskException;
import com.sapienter.jbilling.server.process.db.BillingProcessDTO;

import java.math.BigDecimal;

/**
 * Only allows invoices with a negative balance to be carried over.
 */
public class NegativeBalanceInvoiceFilterTask extends PluggableTask
        implements InvoiceFilterTask {

    public boolean isApplicable(InvoiceDTO invoice, BillingProcessDTO process) 
            throws TaskException {

        if (BigDecimal.ZERO.compareTo(invoice.getBalance()) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
