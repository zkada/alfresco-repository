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
package org.alfresco.model;

import org.alfresco.service.namespace.NamespaceService;
import org.alfresco.service.namespace.QName;

/**
 * @author Kevin Roast
 */
public interface WCMAppModel
{
    // AVM web folder
    static final QName TYPE_AVMWEBFOLDER = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "webfolder");
    static final QName PROP_AVMSTORE = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "avmstore");
    static final QName PROP_DEFAULTWEBAPP = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "defaultwebapp");
    static final QName ASSOC_WEBUSER = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "webuser");
    static final QName ASSOC_WEBFORM = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "webform");
    static final QName ASSOC_WEBWORKFLOWDEFAULTS = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "webworkflowdefaults");
    
    // AVM web user reference
    static final QName TYPE_WEBUSER = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "webuser");
    static final QName PROP_WEBUSERNAME = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "username");
    static final QName PROP_WEBUSERROLE = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "role");
    
    // AVM web form
    static final QName TYPE_WEBFORM = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "webform");
    static final QName PROP_FORMNAME = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "formname");
    static final QName ASSOC_WEBFORMTEMPLATE = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "webformtemplate");
    static final QName ASSOC_WORKFLOWDEFAULTS = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "workflowdefaults");
    
    // AVM web form template
    static final QName TYPE_WEBFORMTEMPLATE = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "webformtemplate");
    static final QName PROP_BASE_RENDERING_ENGINE_TEMPLATE_NAME = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "baserenderingenginetemplatename");
    
    // AVM workflow defaults
    static final QName TYPE_WORKFLOW_DEFAULTS = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "workflowdefaults");
    static final QName PROP_WORKFLOW_NAME = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "workflowname");
    static final QName PROP_WORKFLOW_DEFAULT_PROPERTIES = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "workflowdefaultproperties");
    
    // AVM web workflow defaults
    static final QName TYPE_WEBWORKFLOWDEFAULTS = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "webworkflowdefaults");
    
    // AVM webapp aspect
    static final QName ASPECT_WEBAPP = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "webapp");

    // AVM filename pattern aspect
    static final QName ASPECT_FILENAMEPATTERN = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "filenamepattern");
    static final QName PROP_FILENAMEPATTERN = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "filenamepattern");

    // AVM output path pattern aspect
    static final QName ASPECT_OUTPUT_PATH_PATTERN = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "outputpathpattern");
    static final QName PROP_OUTPUT_PATH_PATTERN = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "outputpathpattern");
    
    // The XForms data capture form aspect.
    static final QName ASPECT_FORM = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "form");
    static final QName PROP_XML_SCHEMA = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "schema");
    static final QName PROP_XML_SCHEMA_ROOT_ELEMENT_NAME = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "xmlschemarootelementname");
    static final QName ASSOC_RENDERING_ENGINE_TEMPLATES = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "renderingenginetemplates");
    static final QName ASSOC_FORM_WORKFLOW_DEFAULTS = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "formworkflowdefaults");
    
    // An XML to something else tranformer aspect.
    static final QName ASPECT_RENDERING_ENGINE_TEMPLATE = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "renderingenginetemplate");
    static final QName PROP_PARENT_RENDERING_ENGINE_NAME = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "parentrenderingenginename");
    static final QName PROP_FORM_SOURCE = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "formsource");
    static final QName ASSOC_RENDITION_PROPERTIES = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "renditionproperties");
    
    static final QName ASPECT_FORM_INSTANCE_DATA = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "forminstancedata");
    static final QName PROP_PARENT_FORM_NAME = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "parentformname");
    static final QName PROP_RENDITIONS = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "renditions");
    
    static final QName ASPECT_RENDITION = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "rendition");
    static final QName PROP_PARENT_RENDERING_ENGINE_TEMPLATE = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "parentrenderingenginetemplate");
    static final QName PROP_PARENT_RENDITION_PROPERTIES = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "parentrenditionproperties");
    static final QName PROP_PRIMARY_FORM_INSTANCE_DATA = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "primaryforminstancedata");
    
    static final QName TYPE_RENDITION_PROPERTIES = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "renditionproperties");
    static final QName PROP_MIMETYPE_FOR_RENDITION = QName.createQName(NamespaceService.WCMAPP_MODEL_1_0_URI, "mimetypeforrendition");
}
