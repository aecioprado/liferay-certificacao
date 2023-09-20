package com.liferay.treinamento.boletim.web.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.treinamento.boletim.model.Tarefa;
import com.liferay.treinamento.boletim.service.TarefaService;
import com.liferay.treinamento.boletim.web.constants.BoletimPortletKeys;
import com.liferay.treinamento.boletim.web.constants.MVCCommandNames;
import com.liferay.treinamento.boletim.web.display.context.TarefasManagementToolbarDisplayContext;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC command para exibir a lista de tarefas.
 *
 * @author liferay
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + BoletimPortletKeys.BOLETIM,
                "mvc.command.name=/",
                "mvc.command.name=" + MVCCommandNames.VIEW_TAREFAS
        },
        service = MVCRenderCommand.class
)
public class ViewTarefasMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws PortletException {

        // Add assignment list related attributes.

        addTarefaListAttributes(renderRequest);

        // Add Clay management toolbar related attributes.

        addManagementToolbarAttributes(renderRequest, renderResponse);

        return "/view.jsp";
    }

    /**
     * Adds assigment list related attributes to the request.
     *
     * @param renderRequest
     */
    private void addTarefaListAttributes(RenderRequest renderRequest) {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        // Resolve start and end for the search.

        int currentPage = ParamUtil.getInteger(
                renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
                SearchContainer.DEFAULT_CUR);

        int delta = ParamUtil.getInteger(
                renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
                SearchContainer.DEFAULT_DELTA);

        int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
        int end = start + delta;

        // Get sorting options.
        // Notice that this doesn't really sort on title because the field is
        // stored in XML. In real world this search would be integrated to the
        // search engine  to get localized sort options.

        String orderByCol =
                ParamUtil.getString(renderRequest, "orderByCol", "title");
        String orderByType =
                ParamUtil.getString(renderRequest, "orderByType", "asc");

        // Create comparator

        OrderByComparator<Tarefa> comparator =
                OrderByComparatorFactoryUtil.create(
                        "Tarefa", orderByCol, !("asc").equals(orderByType));

        // Get keywords.
        // Notice that cleaning keywords is not implemented.

        String keywords = ParamUtil.getString(renderRequest, "keywords");

        // Call the service to get the list of assignments.

        List<Tarefa> assignments =
                _tarefaService.getTarefasByKeywords(
                        themeDisplay.getScopeGroupId(), keywords, start, end,
                        comparator);

        // Set request attributes.

        renderRequest.setAttribute("assignments", assignments);
        renderRequest.setAttribute(
                "assignmentCount", _assignmentService.getAssignmentsCountByKeywords(
                        themeDisplay.getScopeGroupId(), keywords));

    }

    /**
     * Adds Clay management toolbar context object to the request.
     *
     * @param renderRequest
     * @param renderResponse
     */
    private void addManagementToolbarAttributes(
            RenderRequest renderRequest, RenderResponse renderResponse) {

        LiferayPortletRequest liferayPortletRequest =
                _portal.getLiferayPortletRequest(renderRequest);

        LiferayPortletResponse liferayPortletResponse =
                _portal.getLiferayPortletResponse(renderResponse);

        AssignmentsManagementToolbarDisplayContext assignmentsManagementToolbarDisplayContext =
                new AssignmentsManagementToolbarDisplayContext(
                        liferayPortletRequest, liferayPortletResponse,
                        _portal.getHttpServletRequest(renderRequest));

        renderRequest.setAttribute(
                "assignmentsManagementToolbarDisplayContext",
                assignmentsManagementToolbarDisplayContext);

    }

    @Reference
    protected TarefaService _tarefaService;

    @Reference
    private Portal _portal;
}
