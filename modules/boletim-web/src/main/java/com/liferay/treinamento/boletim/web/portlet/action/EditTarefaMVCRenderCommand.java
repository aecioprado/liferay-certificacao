package com.liferay.treinamento.boletim.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.treinamento.boletim.exception.NoSuchTarefaException;
import com.liferay.treinamento.boletim.model.Tarefa;
import com.liferay.treinamento.boletim.service.TarefaService;
import com.liferay.treinamento.boletim.web.constants.BoletimPortletKeys;
import com.liferay.treinamento.boletim.web.constants.MVCCommandNames;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Command for showing edit assignment view.
 *
 * @author liferay
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + BoletimPortletKeys.BOLETIM,
                "mvc.command.name=" + MVCCommandNames.EDIT_TAREFA
        },
        service = MVCRenderCommand.class
)
public class EditTarefaMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        Tarefa tarefa = null;

        long tarefaId = ParamUtil.getLong(renderRequest, "tarefaId", 0);

        if (tarefaId > 0) {
            try {

                // Call the service to get the assignment for editing.

                tarefa = _tarefaService.getTarefa(tarefaId);
            } catch (NoSuchTarefaException nsae) {
                nsae.printStackTrace();
            } catch (PortalException pe) {
                pe.printStackTrace();
            }
        }

        ThemeDisplay themeDisplay =
                (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        // Set back icon visible.

        PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

        portletDisplay.setShowBackIcon(true);

        String redirect = renderRequest.getParameter("redirect");

        portletDisplay.setURLBack(redirect);

        // Set assignment to the request attributes.

        renderRequest.setAttribute("tarefa", tarefa);
        renderRequest.setAttribute("tarefaClass", Tarefa.class);

        return "/tarefa/edit_tarefa.jsp";
    }

    @Reference
    private TarefaService _tarefaService;
}