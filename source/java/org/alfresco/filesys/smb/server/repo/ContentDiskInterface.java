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
package org.alfresco.filesys.smb.server.repo;

import org.alfresco.filesys.server.filesys.DiskInterface;
import org.alfresco.service.cmr.repository.NodeRef;

/**
 * Extended {@link org.alfresco.filesys.server.filesys.DiskInterface disk interface} to
 * allow access to some of the internal configuration properties.
 * 
 * @author Derek Hulley
 */
public interface ContentDiskInterface extends DiskInterface
{
    /**
     * Get the name of the shared path within the server.  The share name is
     * equivalent in browse path to the {@link #getContextRootNodeRef() context root}.
     * 
     * @return Returns the share name
     */
    public String getShareName();
    
    /**
     * Get a reference to the node that all CIFS paths are relative to
     *    
     * @return Returns a node acting as the CIFS root
     */
    public NodeRef getContextRootNodeRef();
}
