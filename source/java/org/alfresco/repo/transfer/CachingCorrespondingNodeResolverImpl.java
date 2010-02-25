/*
 * Copyright (C) 2009-2010 Alfresco Software Limited.
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
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.

 * As a special exception to the terms and conditions of version 2.0 of 
 * the GPL, you may redistribute this Program in connection with Free/Libre 
 * and Open Source Software ("FLOSS") applications as described in Alfresco's 
 * FLOSS exception.  You should have received a copy of the text describing 
 * the FLOSS exception, and it is also available here: 
 * http://www.alfresco.com/legal/licensing"
 */

package org.alfresco.repo.transfer;

import java.util.HashMap;
import java.util.Map;

import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.Path;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author brian
 * 
 */
public class CachingCorrespondingNodeResolverImpl implements CorrespondingNodeResolver
{
    private static final Log log = LogFactory.getLog(CachingCorrespondingNodeResolverImpl.class);
    
    private Map<NodeRef, ResolvedParentChildPair> cache = new HashMap<NodeRef, ResolvedParentChildPair>(359);
    private CorrespondingNodeResolver delegateResolver;

    public CachingCorrespondingNodeResolverImpl()
    {

    }

    /**
     * @param delegateResolver
     */
    public CachingCorrespondingNodeResolverImpl(CorrespondingNodeResolver delegateResolver)
    {
        super();
        this.delegateResolver = delegateResolver;
    }

    public ResolvedParentChildPair resolveCorrespondingNode(NodeRef sourceNodeRef, ChildAssociationRef primaryAssoc,
            Path parentPath)
    {
        
        ResolvedParentChildPair result = cache.get(sourceNodeRef);

        if (result != null)
        {
            if (log.isDebugEnabled()) 
            {
                log.debug("Found fully-resolved entry in cache for node " + sourceNodeRef);
            }
            return result;
        }

        result = delegateResolver.resolveCorrespondingNode(sourceNodeRef, primaryAssoc, parentPath);

        //If we have fully resolved the parent and child nodes then stick it in the cache...
        if (result.resolvedChild != null && result.resolvedParent != null)
        {
            cache.put(sourceNodeRef, result);
        }
        return result;
    }

    /**
     * @param delegateResolver the delegateResolver to set
     */
    public void setDelegateResolver(CorrespondingNodeResolver delegateResolver)
    {
        this.delegateResolver = delegateResolver;
    }
}
