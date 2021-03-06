/**
 * Copyright (C) 2018 Bruno Candido Volpato da Cunha (brunocvcunha@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brunocvcunha.coinpayments.requests;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Builder;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.model.WithdrawalHistoryRecord;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import java.util.List;

@Builder
public class CoinPaymentsGetWithdrawalHistoryRequest extends CoinPaymentsPostRequest<ResponseWrapper<List<WithdrawalHistoryRecord>>>  {
	
	@Builder.Default private int limit = 25;
	
	@Builder.Default private int start = 0;
	
	@Builder.Default private long newer = 0;

	@Override
	public String getUrl() {
		return "";
	}
	
	@Override
    public String getPayload() {
        return "cmd=get_withdrawal_history" + "&limit=" + limit + "&start=" + start + "&newer=" + newer ;
    }

	@Override
	public ResponseWrapper<List<WithdrawalHistoryRecord>> parseResult(int resultCode, String content) {
        ResponseWrapper<List<WithdrawalHistoryRecord>> wrapper = parseJson(content, new TypeReference<ResponseWrapper<List<WithdrawalHistoryRecord>>>() {});
        return wrapper;
	}

}
