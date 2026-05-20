package fordcare_api.service;

import fordcare_api.dto.response.DashboardResponse;
import fordcare_api.repository.CustomerRepository;
import fordcare_api.repository.LeadRepository;
import fordcare_api.repository.PredictionRepository;
import org.springframework.stereotype.Service;

@Service
public class InsightService {

    private final CustomerRepository customerRepository;
    private final PredictionRepository predictionRepository;
    private final LeadRepository leadRepository;

    public InsightService(
            CustomerRepository customerRepository,
            PredictionRepository predictionRepository,
            LeadRepository leadRepository
    ) {
        this.customerRepository = customerRepository;
        this.predictionRepository = predictionRepository;
        this.leadRepository = leadRepository;
    }

    public DashboardResponse getDashboard() {
        Long totalCustomers = customerRepository.count();
        Long highRiskCustomers = predictionRepository.countByRiskLevel("HIGH");
        Long mediumRiskCustomers = predictionRepository.countByRiskLevel("MEDIUM");
        Long lowRiskCustomers = predictionRepository.countByRiskLevel("LOW");
        Long totalLeads = leadRepository.count();
        Long newLeads = leadRepository.countByStatus("NEW");

        return new DashboardResponse(
                totalCustomers,
                highRiskCustomers,
                mediumRiskCustomers,
                lowRiskCustomers,
                totalLeads,
                newLeads
        );
    }
}