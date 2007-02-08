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
package org.alfresco.filesys.server.filesys;

import java.io.IOException;

/**
 * Media Offline Exception Class
 * <p>
 * This exception may be thrown by a disk interface when a file/folder is not available due to the
 * storage media being offline, repository being unavailable, database unavailable or inaccessible
 * or similar condition.
 */
public class MediaOfflineException extends IOException
{
    private static final long serialVersionUID = 3544956554064704306L;

    /**
     * Class constructor.
     */
    public MediaOfflineException()
    {
        super();
    }

    /**
     * Class constructor.
     * 
     * @param s java.lang.String
     */
    public MediaOfflineException(String s)
    {
        super(s);
    }
}
