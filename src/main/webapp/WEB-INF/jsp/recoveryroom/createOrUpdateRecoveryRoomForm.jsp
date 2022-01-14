<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="owners">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#birthDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2>
            Recovery Room
        </h2>
        <form:form modelAttribute="recoveryRoom"
                   class="form-horizontal">
            <input type="hidden" name="id" value="${recoveryRoom.id}"/>
            <div class="form-group has-feedback">
                <petclinic:inputField label="Room name" name="name"/>
                <span class="help-inline"><form:errors path="name"/></span>
                <petclinic:inputField label="Room size in m2" name="size"/>
                <span class="help-inline"><form:errors path="size"/></span>
                <petclinic:checkboxField label="Secure room?" name="secure"/>
                 <span class="help-inline"><form:errors path="secure"/></span>
                <div class="control-group">
                    <petclinic:selectField name="roomType" label="Room type " names="${types}" size="5"/>
                     <span class="help-inline"><form:errors path="roomType"/></span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button class="btn btn-default" type="submit">Update Room</button>
                </div>
            </div>
        </form:form>
    </jsp:body>
</petclinic:layout>
