package com.liferay.treinamento.boletim.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.treinamento.boletim.service.TarefaService;
import com.liferay.treinamento.boletim.web.constants.BoletimPortletKeys;
import com.liferay.treinamento.boletim.web.constants.MVCCommandNames;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for deleting assignments.
 *
 * @author liferay
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + BoletimPortletKeys.BOLETIM,
                "mvc.command.name=" + MVCCommandNames.DELETE_TAREFA
        },
        service = MVCActionCommand.class
)
public class DeleteTarefaMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        // Get assignment id from request.

        long tarefaId = ParamUtil.getLong(actionRequest, "tarefaId");

        try {

            // Call service to delete the assignment.

            _tarefaService.deleteTarefa(tarefaId);

            // Set success message.

            SessionMessages.add(actionRequest, "assignmentDeleted");
        }
        catch (PortalException pe) {

            // Set error messages from the service layer.

            SessionErrors.add(actionRequest, "serviceErrorDetails", pe);
        }

    }

    @Reference
    protected TarefaService _tarefaService;
}
