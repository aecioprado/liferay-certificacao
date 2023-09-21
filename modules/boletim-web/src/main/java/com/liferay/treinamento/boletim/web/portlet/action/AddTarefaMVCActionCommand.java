package com.liferay.treinamento.boletim.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.treinamento.boletim.exception.TarefaValidationException;
import com.liferay.treinamento.boletim.model.Tarefa;
import com.liferay.treinamento.boletim.service.TarefaService;
import com.liferay.treinamento.boletim.web.constants.BoletimPortletKeys;
import com.liferay.treinamento.boletim.web.constants.MVCCommandNames;

import java.util.Date;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Action Command for adding assignments.
 *
 * @author liferay
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + BoletimPortletKeys.BOLETIM,
                "mvc.command.name=" + MVCCommandNames.ADD_TAREFA
        },
        service = MVCActionCommand.class
)
public class AddTarefaMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Tarefa.class.getName(), actionRequest);

        // Get parameters from the request.

        String titulo = ParamUtil.getString(actionRequest, "titulo");

        String descricao = ParamUtil.getString(actionRequest, "descricao", null);

        Date dataFinal = ParamUtil.getDate(actionRequest, "dataFinal", null);
        try {

            // Call the service to add a new assignment.

            _tarefaService.addTarefa(
                    themeDisplay.getScopeGroupId(), titulo, descricao, dataFinal, serviceContext);

            // Set the success message.

            SessionMessages.add(actionRequest, "assignmentAdded");

            sendRedirect(actionRequest, actionResponse);
        }
        catch (TarefaValidationException tve) {

            // Get error messages from the service layer.

            //tve.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));

            tve.printStackTrace();

            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", MVCCommandNames.EDIT_TAREFA);

        }
        catch (PortalException pe) {

            // Set error messages from the service layer.

            SessionErrors.add(actionRequest, "serviceErrorDetails", pe);

            pe.printStackTrace();



            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", MVCCommandNames.EDIT_TAREFA);
        }
    }

    @Reference
    protected TarefaService _tarefaService;

}
