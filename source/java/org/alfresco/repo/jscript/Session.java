/*
 * Copyright (C) 2005 Alfresco, Inc.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.alfresco.repo.jscript;

import org.alfresco.service.ServiceRegistry;

/**
 * Support object for session level properties etc.
 * <p>
 * Provides access to the user's authentication ticket.
 * 
 * @author Andy Hind
 */
public class Session extends BaseScriptImplementation
{
    /** Service registry */
    private ServiceRegistry services;
    
    /**
     * Set the service registry
     * 
     * @param services  the service registry
     */
    public void setServiceRegistry(ServiceRegistry services)
    {
        this.services = services;
    }
    
    /**
     * Get the user's authentication ticket.
     * 
     * @return
     */
    public String getTicket()
    {
        return services.getAuthenticationService().getCurrentTicket();
    }
    
    /**
     * Expose the user's authentication ticket as JavaScipt property.
     * 
     * @return
     */
    public String jsGet_ticket()
    {
        return getTicket();
    }
}
