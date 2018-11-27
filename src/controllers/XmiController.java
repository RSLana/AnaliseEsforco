package controllers;

import models.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XmiController {

    private XStream xstream;

    public XmiController() {
        this.xstream = new XStream(new DomDriver());
        xstream.addPermission(AnyTypePermission.ANY);

        //Formatting
        xstream.alias("xmi:XMI", Root.class);
        xstream.alias("xmi:Documentation", Documentation.class);
        xstream.alias("uml:Model", Model.class);
        xstream.alias("packagedElement", PackagedElement.class);
        xstream.alias("ownedAttribute", OwnedAttribute.class);
        xstream.alias("ownedOperation", OwnedOperation.class);
        xstream.alias("ownedMember", OwnedMember.class);
        xstream.alias("generalization", OwnedMember.class);
        xstream.alias("memberEnd", MemberEnd.class);
        xstream.alias("ownedEnd", OwnedEnd.class);
        xstream.alias("xmi:Extension", Extension.class);
        xstream.alias("stereotype", Stereotype.class);

        xstream.aliasAttribute(Root.class, "xmiVersion", "xmi:version");
        xstream.aliasAttribute(Root.class, "xmlnsUML", "xmlns:uml");
        xstream.aliasAttribute(Root.class, "xmlnsXmi", "xmlns:xmi");
        xstream.aliasField("xmi:Documentation", Root.class, "documentation");
        xstream.aliasField("uml:Model", Root.class, "model");

        xstream.aliasAttribute(Documentation.class, "exporter", "exporter");
        xstream.aliasAttribute(Documentation.class, "exporterVersion", "exporterVersion");

        xstream.aliasAttribute(Model.class, "xmiId", "xmi:id");
        xstream.aliasAttribute(Model.class, "xmiType", "xmi:type");
        xstream.aliasAttribute(Model.class, "name", "name");

        xstream.addImplicitCollection(PackagedElement.class, "packagedElements", PackagedElement.class);
        xstream.addImplicitCollection(PackagedElement.class, "ownedAttributes", OwnedAttribute.class);
        xstream.addImplicitCollection(PackagedElement.class, "ownedOperations", OwnedOperation.class);
        xstream.addImplicitCollection(PackagedElement.class, "ownedMembers", OwnedMember.class);

        xstream.aliasAttribute(PackagedElement.class, "xmiId", "xmi:id");
        xstream.aliasAttribute(PackagedElement.class, "xmiType", "xmi:type");
        xstream.aliasAttribute(PackagedElement.class, "name", "name");
        xstream.aliasAttribute(PackagedElement.class, "visibility", "visibility");
        xstream.aliasAttribute(PackagedElement.class, "isAbstract", "isAbstract");
        xstream.aliasAttribute(PackagedElement.class, "isFinalSpecialization", "isFinalSpecialization");
        xstream.aliasAttribute(PackagedElement.class, "isLeaf", "isLeaf");
        xstream.aliasAttribute(PackagedElement.class, "isActive", "isActive");

        xstream.aliasAttribute(OwnedAttribute.class, "xmiId", "xmi:id");
        xstream.aliasAttribute(OwnedAttribute.class, "name", "name");
        xstream.aliasAttribute(OwnedAttribute.class, "visibility", "visibility");
        xstream.aliasAttribute(OwnedAttribute.class, "isStatic", "isStatic");
        xstream.aliasAttribute(OwnedAttribute.class, "isLeaf", "isLeaf");
        xstream.aliasAttribute(OwnedAttribute.class, "isReadOnly", "isReadOnly");
        xstream.aliasAttribute(OwnedAttribute.class, "isOrdered", "isOrdered");
        xstream.aliasAttribute(OwnedAttribute.class, "isUnique", "isUnique");
        xstream.aliasAttribute(OwnedAttribute.class, "xmiType", "xmi:type");
        xstream.aliasAttribute(OwnedAttribute.class, "aggregation", "aggregation");
        xstream.aliasAttribute(OwnedAttribute.class, "isDerived", "isDerived");
        xstream.aliasAttribute(OwnedAttribute.class, "isID", "isID");

        xstream.aliasAttribute(OwnedOperation.class, "xmiId", "xmi:id");
        xstream.aliasAttribute(OwnedOperation.class, "name", "name");
        xstream.aliasAttribute(OwnedOperation.class, "visibility", "visibility");
        xstream.aliasAttribute(OwnedOperation.class, "isStatic", "isStatic");
        xstream.aliasAttribute(OwnedOperation.class, "isLeaf", "isLeaf");
        xstream.aliasAttribute(OwnedOperation.class, "concurrency", "concurrency");
        xstream.aliasAttribute(OwnedOperation.class, "isQuery", "isQuery");
        xstream.aliasAttribute(OwnedOperation.class, "isAbstract", "isAbstract");
        xstream.aliasAttribute(OwnedOperation.class, "xmiType", "xmi:type");

        xstream.aliasAttribute(OwnedMember.class, "xmiId", "xmi:id");
        xstream.aliasAttribute(OwnedMember.class, "name", "name");
        xstream.aliasAttribute(OwnedMember.class, "visibility", "visibility");
        xstream.aliasAttribute(OwnedMember.class, "xmiType", "xmi:type");
        xstream.aliasAttribute(OwnedMember.class, "isDerived", "isDerived");
        xstream.aliasAttribute(OwnedMember.class, "specific", "specific");
        xstream.aliasAttribute(OwnedMember.class, "general", "general");
        xstream.aliasAttribute(OwnedMember.class, "client", "client");
        xstream.aliasAttribute(OwnedMember.class, "supplier", "supplier");
        xstream.addImplicitCollection(OwnedMember.class, "ownedEnds", OwnedEnd.class);
        xstream.addImplicitCollection(OwnedMember.class, "memberEnds", MemberEnd.class);

        xstream.aliasAttribute(MemberEnd.class, "xmiIdRef", "xmi:idref");

        xstream.aliasAttribute(OwnedEnd.class, "xmiId", "xmi:id");
        xstream.aliasAttribute(OwnedEnd.class, "visibility", "visibility");
        xstream.aliasAttribute(OwnedEnd.class, "isStatic", "isStatic");
        xstream.aliasAttribute(OwnedEnd.class, "isLeaf", "isLeaf");
        xstream.aliasAttribute(OwnedEnd.class, "isReadOnly", "isReadOnly");
        xstream.aliasAttribute(OwnedEnd.class, "isOrdered", "isOrdered");
        xstream.aliasAttribute(OwnedEnd.class, "isUnique", "isUnique");
        xstream.aliasAttribute(OwnedEnd.class, "xmiType", "xmi:type");
        xstream.aliasAttribute(OwnedEnd.class, "aggregation", "aggregation");
        xstream.aliasAttribute(OwnedEnd.class, "isDerived", "isDerived");
        xstream.aliasAttribute(OwnedEnd.class, "isId", "isID");
        xstream.aliasAttribute(OwnedEnd.class, "type", "type");

        xstream.aliasAttribute(Extension.class, "extender", "extender");
        xstream.aliasField("xmi:Extension", OwnedEnd.class, "xmiExtension");

        xstream.aliasAttribute(Stereotype.class, "value", "value");

    }

    public Root loadModel(String path) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(path));
        Root root = (Root) xstream.fromXML(input);
        input.close();

        return root;
    }

    public String toXML(Root root) {
        return xstream.toXML(root);
    }
}
