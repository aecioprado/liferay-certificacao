package com.liferay.treinamento.boletim.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.treinamento.boletim.exception.TarefaValidationException;
import com.liferay.treinamento.boletim.model.Tarefa;
import com.liferay.treinamento.boletim.service.TarefaService;
import com.liferay.treinamento.boletim.web.constants.BoletimPortletKeys;
import com.liferay.treinamento.boletim.web.constants.MVCCommandNames;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for editing assignments.
 *
 * @author liferay
 *
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + BoletimPortletKeys.BOLETIM,
                "mvc.command.name=" + MVCCommandNames.EDIT_TAREFA
        },
        service = MVCActionCommand.class
)
public class EditTarefaMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        ServiceContext serviceContext =
                ServiceContextFactory.getInstance(Tarefa.class.getName(), actionRequest);

        // Get parameters from the request.

        long tarefaId = ParamUtil.getLong(actionRequest, "tarefaId");

        String titulo = ParamUtil.getString(actionRequest, "titulo");

        String descricao = ParamUtil.getString(actionRequest, "descricao", null);

        Date dataFinal = ParamUtil.getDate(actionRequest, "dataFinal", null);
        try {

            // Call the service to update the assignment

            _tarefaService.updateTarefa(
                    tarefaId, titulo, descricao, dataFinal, serviceContext);

            // Set the success message.

            SessionMessages.add(actionRequest, "assignmentUpdated");

            sendRedirect(actionRequest, actionResponse);
        }
        catch (TarefaValidationException ave) {

            // Get error messages from the service layer.

            //ave.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));

            ave.printStackTrace();

            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", MVCCommandNames.EDIT_TAREFA);

        }
        catch (PortalException pe) {

            // Get error messages from the service layer.

            SessionErrors.add(actionRequest, "serviceErrorDetails", pe);

            pe.printStackTrace();

            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", MVCCommandNames.EDIT_TAREFA);
        }
    }

    @Reference
    protected TarefaService _tarefaService;
}
