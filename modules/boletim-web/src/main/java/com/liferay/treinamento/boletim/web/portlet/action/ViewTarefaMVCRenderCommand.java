package com.liferay.treinamento.boletim.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.treinamento.boletim.model.Tarefa;
import com.liferay.treinamento.boletim.service.TarefaService;
import com.liferay.treinamento.boletim.web.constants.BoletimPortletKeys;
import com.liferay.treinamento.boletim.web.constants.MVCCommandNames;

import java.text.DateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + BoletimPortletKeys.BOLETIM,
		"mvc.command.name=" + MVCCommandNames.VIEW_TAREFA
	},
	service = MVCRenderCommand.class
)
public class ViewTarefaMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long tarefaId = ParamUtil.getLong(renderRequest, "tarefaId", 0);

		try {

			// Call the service to get the assignment.

			Tarefa tarefa = _tarefaService.getTarefa(tarefaId);

			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
				"EEEEE, MMMMM dd, yyyy");

			// Set attributes to the request.

			renderRequest.setAttribute(
				"createDate", dateFormat.format(tarefa.getCreateDate()));
			renderRequest.setAttribute(
				"dataFinal", dateFormat.format(tarefa.getDataFinal()));
			renderRequest.setAttribute("tarefa", tarefa);

			// Set back icon visible.

			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			String redirect = renderRequest.getParameter("redirect");

			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(redirect);

			return "/tarefa/view_tarefa.jsp";
		}
		catch (PortalException pe) {
			throw new PortletException(pe);
		}
	}

	@Reference
	private Portal _portal;

	@Reference
	private TarefaService _tarefaService;

	@Reference
	private UserLocalService _userLocalService;

}